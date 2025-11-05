package com.javabro;

public record UserRecord() implements UserInterface {

    @Override
    public String getUserDetails(Long id) {
        return "";
    }
}
