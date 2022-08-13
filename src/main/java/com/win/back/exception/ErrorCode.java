package com.win.back.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCode {

    sendFailed(553,"COMMON-ERR-553","sendFailedException");

    private int status;
    private String errorCode;
    private String message;
}
