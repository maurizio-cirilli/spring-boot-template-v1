package com.example.demo.dto;

import lombok.Generated;

@Generated
public abstract class BaseResponse {

    public BaseResponse() {
        super();
    }

    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
