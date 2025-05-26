package com.example.f02_online_shopping.service.impl;

import com.example.f02_online_shopping.dto.request.user.UserRegisterRequestDto;
import com.example.f02_online_shopping.service.UserValidatorService;
import org.springframework.stereotype.Service;

@Service
public class UserValidatorServiceImpl implements UserValidatorService {

    @Override
    public Object validateCreateUserRequest(UserRegisterRequestDto dto) {
        Object validateEmail = validateEmail(dto.getEmail());
        Object validatePassword = validatePassword(dto.getPassword());
        Object validateFullName = validateFullName(dto.getFullName());
        if(validateEmail == null && validatePassword == null && validateFullName == null) {
            return null;
        }
        if(validateEmail != null){
            return validateEmail;
        }
        if(validatePassword != null){
            return validatePassword;
        }
        return validateFullName;
    }

    public Object validateEmail(String email){
        if(email == null || email.trim().isEmpty()){
            return "Email is required";
        }
        if(email.length() > 255){
            return "Email is too long";
        }
        // Basic email regex pattern
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if(!email.matches(emailRegex)){
            return "Invalid Email";
        }
        return null;
    }

    public Object validatePassword(String password){
        if(password == null ){
            return "Password is required";
        }
        if(password.length() < 8){
            return "Password is too short";
        }
        if(password.length() > 128){
            return "Password is too long";
        }
        return null;
    }

    public Object validateFullName(String fullName){
        if(fullName == null ){
            return "Full Name is required";
        }
        // Full name must contain only letters and spaces
        String nameRegex = "^[A-Za-z ]+$";

        if (!fullName.matches(nameRegex)) {
            return "Name should only contain alphanumeric characters";
        }
        if(fullName.length() < 2){
            return "Name is too short";
        }
        if(fullName.length() > 128){
            return "Name is too long";
        }
        return null;
    }
}
