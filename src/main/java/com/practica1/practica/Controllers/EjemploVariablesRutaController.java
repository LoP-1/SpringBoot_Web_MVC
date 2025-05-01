package com.practica1.practica.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    //cargar el titulo y un valor para ser usado despues
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("titulo","Elije la ruta para revisar las variables");
        model.addAttribute("nombre","Miguel");
        return "variables/index";
    }

    //enviando solo un valor a travez de la url
    @GetMapping("/String/{texto}")
    public String variables (@PathVariable(name = "texto") String texto2, Model model){

        model.addAttribute("titulo","Recibir Valores de la ruta (usando path variable)");
        model.addAttribute("text","El texto enviado es: " + texto2);
    return "variables/ver";
    }

    //enviando 2 valores a travez de la url
    @GetMapping("/String/{texto}/{numero}")
    public String variables (@PathVariable String texto,@PathVariable Integer numero, Model model){

        model.addAttribute("titulo","Recibir Valores de la ruta (usando path variable pero 2 valores)");
        model.addAttribute("text","El texto enviado es: " + texto + " el numero enviado es: " + numero);
        return "variables/ver";
    }

}
