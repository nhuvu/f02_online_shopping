package com.example.f02_online_shopping.constant;

public class UrlConstant {
    //Base and General Path
    //1. Base
    public static final String API_V1_BASE = "/api/v1";
    //2. Authentication
    public static final String AUTH = "/auth";
    public static final String LOGIN = AUTH + "/login";
    public static final String REGISTER = AUTH + "/register";
    //3. User & admin
    public static final String USERS = "/users";
    public static final String CRUD_USER = USERS + "/{id}";
    public static final String USER_PROFILE = USERS + "/me";
    public static final String ADMIN = "/admin";
    public static final String CRUD_ADMIN = ADMIN + "/{id}";
    public static final String ADMIN_USERS = ADMIN + USERS;
    public static final String CRUD_ADMIN_USERS = ADMIN + CRUD_USER;
    //4. Product
    public static final String PRODUCTS =  "/products";
    public static final String CRUD_PRODUCT = PRODUCTS + "/{id}";
    public static final String ADMIN_PRODUCTS = ADMIN + PRODUCTS;
    public static final String CRUD_ADMIN_PRODUCTS = ADMIN + CRUD_PRODUCT;
    //5. Cart
    public static final String CARTS = "/carts";
    public static final String CRUD_CART = CARTS + "/{id}";
    public static final String CART_ITEMS = CARTS + "/items";
    public static final String CRUD_CART_ITEMS = CART_ITEMS + "/{id}";
    public static final String USER_CART = USERS + CARTS;
    public static final String CRUD_USER_CART = USER_PROFILE + CRUD_CART;
    //6. Order
    public static final String ORDERS = "/orders";
    public static final String CRUD_ORDER = ORDERS + "/{id}";
    public static final String ORDER_ITEMS = ORDERS + "/items";
    public static final String CRUD_ORDER_ITEMS = ORDER_ITEMS + "/{id}";
    public static final String USER_ORDERS = USERS + ORDERS;
    public static final String CRUD_USER_ORDERS = USER_PROFILE + CRUD_ORDER;

    //User biz functions
    public static final String PRODUCT_GET_IN_STOCK = PRODUCTS + "/in-stock";
    public static final String ORDER_HISTORY = CRUD_ORDER + "/history";

    //Admin biz functions
    public static final String BLOCK_USER = ADMIN_USERS + "/block";
    public static final String SEARCH_USER = ADMIN_USERS + "/search";


}
