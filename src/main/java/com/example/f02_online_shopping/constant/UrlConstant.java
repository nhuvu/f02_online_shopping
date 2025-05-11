package com.example.f02_online_shopping.constant;

public class UrlConstant {
    //User biz function
    public static final String API_V1_USER_REGISTER = "api/v1/users/register";
    public static final String API_V1_USER_LOGIN = "api/v1/users/login";
    public static final String API_V1_PRODUCT_GET_IN_STOCK = "api/v1/products/in-stock";
    public static final String API_V1_CART_GET_BY_USER = "api/v1/carts/user/{userId}";
    public static final String API_V1_CART_ADD_PRODUCT = "api/v1/carts/product/add/{productId}";
    public static final String API_V1_CART_DELETE_PRODUCT = "api/v1/carts/product/delete/{productId}";
    public static final String API_V1_ORDER_GET_BY_USER = "api/v1/orders/user/{userId}";
    public static final String API_V1_ORDER_PLACE= "api/v1/orders/add";
    public static final String API_V1_ORDER_FIND_BY_ID = "api/v1/orders/{orderId}";
    public static final String API_V1_ORDER_HISTORY = "api/v1/orders/history";
    public static final String API_V1_ORDER_UPDATE = "api/v1/orders/update";
    public static final String API_V1_ORDER_CANCEL = "api/v1/orders/cancel";

    //Admin biz function
    public static final String API_V1_ADMIN_LOGIN = "api/v1/admins/login";
    public static final String API_V1_USER_GET_ALL = "api/v1/users";
    public static final String API_V1_USER_FIND_BY_ID = "api/v1/users/{userId}";
    public static final String API_V1_USER_BLOCK = "api/v1/users/block/{userId}";
    public static final String API_V1_PRODUCT_ADD = "api/v1/products/add";
    public static final String API_V1_PRODUCT_UPDATE = "api/v1/products/update";
    public static final String API_V1_PRODUCT_DELETE = "api/v1/products/delete";
    public static final String API_V1_PRODUCT_GET_ALL = "api/v1/products";
    public static final String API_V1_PRODUCT_FIND_BY_ID = "api/v1/products/{productId}";
    public static final String API_V1_PRODUCT_FIND_BY_CATEGORY = "api/v1/products/category/{categoryName}";

}
