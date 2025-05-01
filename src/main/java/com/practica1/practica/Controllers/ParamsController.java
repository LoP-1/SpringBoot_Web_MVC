package com.practica1.practica.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/params")
public class ParamsController {

    //en resumen hacen lo mismo que el pathVariable
    //cargar el index al poner la url de la raiz
    @GetMapping("/")
    public String index(){
        return "params/index";
    }

    //leer un parametro a travez de la url
    @GetMapping("/mix-params")
    public String param(@RequestParam String texto,@RequestParam Integer numero, Model model){
        model.addAttribute("resultado","El texto enviado es: " + texto + " el numero es: " + numero);
        return "params/ver";
    }

    //lo mismo pero ahora evitando errores con valores por defecto y el texto no requerido
    @GetMapping("/string")
    public String param(@RequestParam(name = "texto",required = false,defaultValue = "Que God")String texto, Model model){
        model.addAttribute("resultado","El texto enviado es: " + texto);
        return "params/ver";
    }

    //otra forma de realizar la llamada de todas maneras usar pathVariable es mas facil

    //... aunque esta parte no esta nada mal
    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model){
        String texto = request.getParameter("texto");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            numero = 0;
        }

        model.addAttribute("resultado","El texto enviado es: " + texto + " el numero es: " + numero);
        return "params/ver";
    }

}
