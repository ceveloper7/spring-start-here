package com.gba.sprg_ch09_ex2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


/**
 * Cada vez que el usuario se loggea exitosamente almacenamos el nombre de usuario
 * en un bean llamado LoggedUserManagementService con atributo username
 * @SessionScope permite que el username sea accesible durante toda la sesion http
 */
@Service
@SessionScope
public class LoggedUserManagementService {
    private String username;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
