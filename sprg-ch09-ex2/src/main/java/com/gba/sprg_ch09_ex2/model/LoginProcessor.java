package com.gba.sprg_ch09_ex2.model;

import com.gba.sprg_ch09_ex2.service.LoggedUserManagementService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Usamos este bean para crear cada instancia del Login Request
 */
@Component
@RequestScope
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;

    // Solo necesitamos los valores de atributos username y password durante request
    private String username;
    private String password;

    // auto wired (constructor injection)
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService){
        this.loggedUserManagementService = loggedUserManagementService;
    }

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
        String username = this.getUsername();
        String password = this.getPassword();

        boolean loginResult = false;

        if("natalie".equals(username) && "password".equals(password)){
            loginResult = true;
            // almacenamos el username en el bean LoggedUserManagementService
            loggedUserManagementService.setUsername(username);
        }

        return loginResult;
    }
}
