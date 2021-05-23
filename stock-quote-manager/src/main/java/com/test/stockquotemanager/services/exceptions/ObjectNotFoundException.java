package com.test.stockquotemanager.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID=1L;

    //mostra uma mensagem de erro
    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    //mostra mensagem e a causa deste erro
    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
