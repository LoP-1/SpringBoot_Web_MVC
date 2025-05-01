package com.practica1.practica.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        //envia a la url marcada una redireccion de toda la vida
        //puede ser cualquier url
        return "forward:/app/index";    }

    //usar redirect si cambia la url
    //usar forward no modifica la url, solo a paginas internas
}
