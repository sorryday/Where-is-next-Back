package com.win.back.emailAuth;

public interface EmailService {
    String sendSignUpMessage(String to)throws Exception;
    String sendSearchMessage(String to) throws Exception;
    String getCode()throws Exception;
    void setCode(String to)throws Exception;
}
