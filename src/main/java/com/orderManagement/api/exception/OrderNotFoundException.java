package com.orderManagement.api.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Could not find order having id :  " + id);
    }

}

