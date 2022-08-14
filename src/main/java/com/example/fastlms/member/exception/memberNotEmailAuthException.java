package com.example.fastlms.member.exception;

public class memberNotEmailAuthException extends RuntimeException {
    public memberNotEmailAuthException(String error) {
        super(error);
    }
}
