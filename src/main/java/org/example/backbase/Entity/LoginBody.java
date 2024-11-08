package org.example.backbase.Entity;

import org.springframework.stereotype.Component;

@Component
public class LoginBody {

    private String username;

    private String password;

    public String getPassword() {
        return password;
    }

    public LoginBody(){}

    public LoginBody(String username, String password){
        this.password = password;
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
