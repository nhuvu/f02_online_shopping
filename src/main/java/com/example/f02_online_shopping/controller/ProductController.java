package com.example.f02_online_shopping.controller;

import com.example.f02_online_shopping.constant.UrlConstant;
import com.example.f02_online_shopping.exception.ApiException;
import com.example.f02_online_shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstant.API_V1_BASE)
public class ProductController {

    @Autowired
    ProductService productService;

    /** [F03] Xem danh sách các sản phẩm đang được bán. (ORM-1)
     * */
    @GetMapping(UrlConstant.PRODUCT_GET_IN_STOCK)
    public ResponseEntity<Object> getProductInStock(){
        try{
            return ResponseEntity.ok(productService.getInStockProductList());
        }catch (ApiException e){
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

}
