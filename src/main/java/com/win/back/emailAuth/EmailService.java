package com.win.back.emailAuth;

public interface EmailService {
    String sendSimpleMessage(String to)throws Exception;
    String getCode()throws Exception;
    void setCode(String to)throws Exception;
}
