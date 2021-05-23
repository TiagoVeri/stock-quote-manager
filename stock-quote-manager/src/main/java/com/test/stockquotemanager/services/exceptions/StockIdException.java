package com.test.stockquotemanager.services.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StockIdException extends RuntimeException{
	public StockIdException(String message) {
        super(message);
    }
}
