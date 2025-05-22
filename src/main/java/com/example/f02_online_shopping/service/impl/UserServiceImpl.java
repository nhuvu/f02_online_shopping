package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.user.UserLoginRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserRegisterRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserUpdateRequestDto;
import com.example.f02_online_shopping.dto.response.user.UserResponseDto;
import com.example.f02_online_shopping.entity.Order;
import com.example.f02_online_shopping.entity.User;
import com.example.f02_online_shopping.exception.ApiException;
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

    @Override
    public UserResponseDto registerUser(UserRegisterRequestDto request) {
        //Validate user
        Object error = userValidatorService.validateCreateUserRequest(request);
        if (error != null) {
            throw new ApiException(401, "User detail not valid");
        }
        User userExist = userRepository.findByFullname(request.getFullName());
        if(userExist != null){
            throw new ApiException(400, "User already exists");
        }

        //Create user
        User userCreate = new User();
        userCreate.setFullname(request.getFullName());
        userCreate.setPassword(passwordEncoder.encode(request.getPassword())); //encode psw trước khi lưu xuống db
        userCreate.setEmail(request.getEmail());
        userCreate.setRole("USER");
        userCreate.setStatus("ACTIVE");
        userRepository.save(userCreate);

        //Return response
        return new UserResponseDto(request.getFullName(), request.getEmail());
    }

    @Override
    public void checkUserValidity(Integer id) {
        //TODO: CHECK USER VALIDITY
        if(id == null){
            throw new ApiException(401, "Id is invalid");
        }
        if(id <= 0){
            throw new ApiException(401, "Id is invalid");
        }
    }

    @Override
    public UserResponseDto login(UserLoginRequestDto request) {
        return null;
    }

    @Override
    public UserResponseDto getUserById(Integer id) {
        //validate id
        checkUserValidity(id);
        //get id
        //Optional<User> user = userRepository.findById(id);
        Optional<User> user = Optional.ofNullable(userRepository.findByUserId(id));

        if(user.isEmpty()){
            throw new ApiException(404, "User not found");
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

    @Override
    public List<UserResponseDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserResponseDto blockUser(Integer id) {
        return null;
    }

    @Override
    public UserResponseDto updateUser(UserUpdateRequestDto request) {
        int rowAffects = userRepository.updateUser(
                request.getId(),
                request.getFullName(),
                request.getEmail(),
                request.getPassword()
        );
        if(rowAffects <= 0){
            throw new ApiException(404, "User not found");
        }

        return new UserResponseDto(
                request.getId(),
                request.getEmail(),
                request.getFullName());
    }
}
