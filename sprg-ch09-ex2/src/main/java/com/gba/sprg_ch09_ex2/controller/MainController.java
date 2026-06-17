package com.gba.sprg_ch09_ex2.controller;

import com.gba.sprg_ch09_ex2.service.LoggedUserManagementService;
import com.gba.sprg_ch09_ex2.service.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 1. El usuario accede al a http://localhost:8080/
 * 2. esta el username almacenado en bean session scoped?. si esta almacenado, significa que esta autenticado
 * 3. Si no esta almacenado el username, el client es re dirigido al login page
 * 4. Si el username esta almacenado, el cliente es enviado a la pagina main.
 */
@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService){
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    /**
     *
     * @param logout - cuando el controller recibe el paremeto logout entonces se borra el username
     *                 almacenado en el session scope bean
     * @param model - model parameter nos permite enviar el username a la vista
     * @return
     */
    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model model) {
        // si parametro logout esta presente, borramos el username guardado en el LoggedUserManagementService session scoped
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        // obtenemos el username almacenado en el session scoped bean, si no es null, hay un user autenticado
        String username = loggedUserManagementService.getUsername();
        int count = loginCountService.getCount();

        // si no hay usuario autenticado, se re dirige al cliente al login page
        if (username == null) {
            return "redirect:/";
        }

        // hacemos disponibles para la vista username y loginCount
        model.addAttribute("username" , username);
        model.addAttribute("loginCount", count);

        // si el usuario esta autenticado, retornamos la vista a la pagina main
        return "main.html";
    }
}
