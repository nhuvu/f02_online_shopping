package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.user.UserLoginRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserRegisterRequestDto;
import com.example.f02_online_shopping.dto.response.user.UserResponseDto;
import com.example.f02_online_shopping.entity.Cart;
import com.example.f02_online_shopping.entity.User;
import com.example.f02_online_shopping.exception.UserException;
import com.example.f02_online_shopping.repository.CartRepository;
import com.example.f02_online_shopping.repository.UserRepository;
import com.example.f02_online_shopping.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public UserResponseDto login(UserLoginRequestDto request) {
        User userExist = Optional.ofNullable(userRepository.findByEmail(request.getEmail()))
                .orElseThrow(() -> new UserException(404, "User not found with email: " + request.getEmail()));
        if(passwordEncoder.matches(request.getPassword(), userExist.getPassword())){
            return new UserResponseDto(
                    userExist.getEmail(),
                    userExist.getFullname(),
                    userExist.getStatus(),
                    userExist.getRole()
            );
        }
        throw new UserException(401, "Invalid password");
    }

    @Override
    public UserResponseDto createUser(UserRegisterRequestDto request) {
        Optional<User> userExist = Optional.ofNullable(userRepository.findByFullname(request.getFullName()));
        if(userExist.isPresent()){
            throw new UserException(404, "User already exists");
        }
        //Create user
        User userCreate = new User();
        userCreate.setFullname(request.getFullName());
        userCreate.setPassword(passwordEncoder.encode(request.getPassword())); //encode psw trước khi lưu xuống db
        userCreate.setEmail(request.getEmail());
        userCreate.setRole("USER");
        userCreate.setStatus("ACTIVE");
        userRepository.save(userCreate);
        //Create a new cart respectively to map with new user created
        Cart cartCreate = new Cart();
        cartCreate.setUser(userCreate);
        cartRepository.save(cartCreate);
        //Return response
        return new UserResponseDto(
                request.getFullName(),
                request.getEmail());
    }
}
