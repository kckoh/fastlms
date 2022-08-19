package com.example.fastlms.member.exception;

import java.util.Scanner;

public class memberNotEmailAuthException extends RuntimeException {
    public memberNotEmailAuthException(String error) {
        super(error);

    }
}
