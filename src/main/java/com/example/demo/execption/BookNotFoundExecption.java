package com.example.demo.execption;

import org.springframework.http.HttpStatus;

import java.util.List;

public class BookNotFoundExecption extends Exception {

    private ErrorBean errorBean;

    public BookNotFoundExecption() {

    }

    public BookNotFoundExecption(String message) {
        super(message);
        errorBean = new ErrorBean(HttpStatus.UNPROCESSABLE_ENTITY, message, (List<String>) null);

    }

    public BookNotFoundExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotFoundExecption(Throwable cause) {
        super(cause);
    }

    public BookNotFoundExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ErrorBean getErrorBean() {
        return errorBean;
    }

    public void setErrorBean(ErrorBean errorBean) {
        this.errorBean = errorBean;
    }
}
