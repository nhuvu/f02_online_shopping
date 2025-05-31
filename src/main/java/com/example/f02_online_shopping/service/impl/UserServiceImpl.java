package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.constant.Constant;
import com.example.f02_online_shopping.dto.request.user.UserLoginRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserRegisterRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserUpdateRequestDto;
import com.example.f02_online_shopping.dto.response.user.UserResponseDto;
import com.example.f02_online_shopping.entity.Cart;
import com.example.f02_online_shopping.entity.Order;
import com.example.f02_online_shopping.entity.User;
import com.example.f02_online_shopping.exception.UserException;
import com.example.f02_online_shopping.repository.CartRepository;
import com.example.f02_online_shopping.repository.UserRepository;
import com.example.f02_online_shopping.service.UserService;
import com.example.f02_online_shopping.service.UserValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserValidatorService userValidatorService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private CartRepository cartRepository;

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
    public UserResponseDto getUserByEmail(String email) {
        User user = Optional.ofNullable(userRepository.findUserByEmail(Constant.USER, email))
                .orElseThrow(() -> new UserException(404, "There is no user exist with email: " + email));
        return new UserResponseDto(
                user.getId(),
                user.getEmail(),
                user.getFullname(),
                user.getStatus(),
                user.getRole()
        );
    }

    @Override
    public UserResponseDto blockUser(Integer id) {
        //find user by id
        User userExist = Optional.ofNullable(userRepository.findByUserId(id))
                .orElseThrow(() -> new UserException(404, "User not found with id: " + id));
        //check role of user, if it's ADMIN -> will not block
        if(userExist.getRole().equals(Constant.ADMIN)){
            throw new UserException(403, "You are not allowed to block this user");
        }
        //check current status of user, if it's already BLOCK -> will not block
        if(userExist.getStatus().equals(Constant.BLOCK)){
            throw new UserException(409, "User is already blocked");
        }
        //block user (update status to BLOCK)
        userRepository.updateUserStatus(
                id,
                Constant.BLOCK
        );
        return new UserResponseDto(
                id,
                userExist.getStatus(),
                userExist.getRole());
    }

    @Override
    public void checkUserValidity(Integer id) {
        //TODO: CHECK USER VALIDITY
        if(id == null){
            throw new UserException(401, "Id is invalid");
        }
        if(id <= 0){
            throw new UserException(401, "Id is invalid");
        }
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAllByRole(Constant.USER);
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for(User user : users){
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setId(user.getId());
            userResponseDto.setEmail(user.getEmail());
            userResponseDto.setRole(user.getRole());
            userResponseDto.setStatus(user.getStatus());
            userResponseDto.setFullName(user.getFullname());
            userResponseDtos.add(userResponseDto);
        }
        return userResponseDtos;
    }


    public UserResponseDto updateUser(UserUpdateRequestDto request) {
        int rowAffects = userRepository.updateUserInfo(
                request.getId(),
                request.getFullName(),
                request.getEmail(),
                request.getPassword()
        );
        if(rowAffects <= 0){
            throw new UserException(404, "User not found");
        }
        return new UserResponseDto(
                request.getId(),
                request.getEmail(),
                request.getFullName());
    }

    public UserResponseDto getUserById(Integer id) {
        //validate id
        checkUserValidity(id);
        //get id
        Optional<User> user = Optional.ofNullable(userRepository.findByUserId(id));

        if(user.isEmpty()){
            throw new UserException(404, "User not found");
        }
        User userDetail = user.get();

        //Build list order details
        List<String> orderDetails = new ArrayList<>();
        for(Order order : userDetail.getOrders()){
            orderDetails.add("Order id: " + order.getId() + "; status: " + order.getStatus() + "; total amount: " + order.getTotal_amount());
        }
        return new UserResponseDto(userDetail.getId(),
                userDetail.getFullname(),
                userDetail.getEmail(),
                userDetail.getStatus(),
                userDetail.getRole(),
                userDetail.getCart().getId(),
                orderDetails);
    }
}
