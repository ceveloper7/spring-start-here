package com.gba.sprg_ch09_ex1.processor;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Bean recibe la credenciales del usuario y las valida (login logic)
 * @RequestScope -> permite que cada instancia sea una HTTP request unica
 */
@Controller
@RequestScope
public class LoginProcessor {
    private String username;
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

    public boolean login(){
        String username = getUsername();
        String password = getPassword();

        if ("natalie".equals(username) && "password".equals(getPassword())){
            return true;
        }else{
            return false;
        }
    }


}
