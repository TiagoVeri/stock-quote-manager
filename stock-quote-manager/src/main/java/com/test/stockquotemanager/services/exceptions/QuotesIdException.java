package com.test.stockquotemanager.services.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuotesIdException extends RuntimeException{
	public QuotesIdException(String message) {
        super(message);
    }
}
