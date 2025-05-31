package com.example.f02_online_shopping.exception.handler;

import com.example.f02_online_shopping.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //ApiException là con RuntimeException là con Exception
    //Nhưng dc định nghĩa và xử lý cụ thể -> ưu tiên dùng xử lý cụ thể này
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleApiException(ApiException e){
        return ResponseEntity
                .status(e.getHttpCode())
                .body(e.getMessage());
    }

    //handle bind exception đề xử lý validation cho dto
    //***phải có @Valid truyền vào param của hàm trong Controller
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> handleBindException(BindException e){
        return ResponseEntity
                .status(400)
                .body(e.getAllErrors().get(0).getDefaultMessage());
    }

    //xử lý class cha Exception -> tất cả exception nào kế thừa Exception sẽ dc catch & handle như sau
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e){
        return ResponseEntity
                .status(500)
                .body("Internal Server Error"); //luôn quăng message lỗi chung chung
    }
}

