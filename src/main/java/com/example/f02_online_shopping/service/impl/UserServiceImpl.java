package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.user.UserLoginRequestDto;
import com.example.f02_online_shopping.dto.request.user.UserRegisterRequestDto;
import com.example.f02_online_shopping.dto.response.user.UserDto;
import com.example.f02_online_shopping.entity.Order;
import com.example.f02_online_shopping.entity.User;
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
    public UserDto registerUser(UserRegisterRequestDto request) {
        //Validate user
        Object error = userValidatorService.validateCreateUserRequest(request);
        if (error != null) {
            UserDto response = new UserDto();
            response.setError(error);
            return response;
        }
        User userExist = userRepository.findByFullname(request.getFullName());
        if(userExist != null){
            UserDto res = new UserDto();
            res.setError("User already exists");
            return res;
        }

        //Create user
        User userCreate = new User();
        userCreate.setFullname(request.getFullName());
        userCreate.setPassword(request.getPassword());
        userCreate.setEmail(request.getEmail());
        userCreate.setRole("USER");
        userCreate.setStatus("ACTIVE");
        userRepository.save(userCreate);

        //Return response
        UserDto response = new UserDto();
        response.setFullName(request.getFullName());
        response.setEmail(request.getEmail());
        return response;
    }

    @Override
    public void checkUserValidity(Integer id) {

    }


    @Override
    public UserDto login(UserLoginRequestDto request) {
        return null;
    }

    @Override
    public UserDto getUserByid(Integer id) {
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
        return new UserDto(userDetail.getId(),
                            userDetail.getFullname(),
                            userDetail.getEmail(),
                            userDetail.getStatus(),
                            userDetail.getRole(),
                            userDetail.getCart().getId(),
                            orderDetails);
    }
}
