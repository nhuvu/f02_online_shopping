package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.UserCreationRequestDto;
import com.example.f02_online_shopping.dto.response.UserCreationResponseDto;
import com.example.f02_online_shopping.dto.response.UserDetailResponseDto;
import com.example.f02_online_shopping.entity.Order;
import com.example.f02_online_shopping.entity.User;
import com.example.f02_online_shopping.model.UserModel;
import com.example.f02_online_shopping.repository.UserRepository;
import com.example.f02_online_shopping.service.UserService;
import com.example.f02_online_shopping.service.UserValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public void checkUserValidity(UserModel user) {
        //TODO: CHECK USER VALID
    }

    @Override
    public UserCreationResponseDto createUser(UserCreationRequestDto request) {
        //Validate user
        Object error = userValidatorService.validateCreateUserRequest(request);
        if (error != null) {
            UserCreationResponseDto response = new UserCreationResponseDto();
            response.setError(error);
            return response;
        }
        User userExist = userRepository.findByFullname(request.getUsername());
        if(userExist != null){
            UserCreationResponseDto res = new UserCreationResponseDto();
            res.setError("User already exists");
            return res;
        }

        //Create user
        User userCreate = new User();
        userCreate.setFullname(request.getUsername());
        userCreate.setPassword(request.getPassword());
        userCreate.setEmail(request.getEmail());
        userCreate.setRole(request.getRole());
        userCreate.setStatus(request.getStatus());
        userRepository.save(userCreate);

        //Return response
        UserCreationResponseDto response = new UserCreationResponseDto();
        response.setUsername(request.getUsername());
        response.setEmail(request.getEmail());
        return response;
    }

    @Override
    public UserDetailResponseDto getUserByid(Integer id) {
        //validate id
        if(id == null){
            return null;
        }
        if(id <= 0){
            return null;
        }
        //get id
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
          return null;
        }
        User userDetail = user.get();

        //Build list order details
        List<String> orderDetails = new ArrayList<>();
        for(Order order : userDetail.getOrders()){
            orderDetails.add("Order id: " + order.getId() + "; status: " + order.getStatus() + "; total amount: " + order.getTotal_amount());
        }
        return new UserDetailResponseDto(userDetail.getEmail(),
                                            userDetail.getId(),
                                            userDetail.getStatus(),
                                            userDetail.getRole(),
                                            userDetail.getCart().getId(),
                                            orderDetails);
    }
}
