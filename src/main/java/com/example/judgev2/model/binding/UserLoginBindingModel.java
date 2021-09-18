package com.example.judgev2.model.binding;

import org.hibernate.validator.constraints.Length;

public class UserLoginBindingModel {
    @Length(min = 2, message = "Username length must be min 2 symbols")
    private String username;
    @Length(min = 3, message = "Password length must be min 3 symbols")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
