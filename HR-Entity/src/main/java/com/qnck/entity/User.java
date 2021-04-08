package com.qnck.entity;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String userName;
    private String userTrueName;
    private String userPassword;
    private Identity identity;
}
