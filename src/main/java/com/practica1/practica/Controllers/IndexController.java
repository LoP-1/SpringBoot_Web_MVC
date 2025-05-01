package com.practica1.practica.Controllers;

import com.practica1.practica.Models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/app")
public class IndexController {


    //@values para sacar datos del properties
    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;
    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;



    //model envia el atributo con su valor
    //model and View manda model pero tambien envia view .setviewname
    //cargar el titulo del programa jeje
    @GetMapping({"/index", "/", "home"})
    public String index(Model model) {
        //se reemplazo con los values de arriba
        model.addAttribute("titulo",textoIndex);
        return "index";
    }

    //enviar un objeto de tipo usuario al html de thymeleaf usando el model
    @RequestMapping("/perfil")
    public String perfil(Model model){
        //crear un nuevo usuario
        Usuario usuario = new Usuario();
        //agregar datos al usuario
        usuario.setApellido("Castillo");
        usuario.setNombre("Miguel");
        usuario.setEmail("miguelgozu@gmail.com");

        model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
        model.addAttribute("usuario",usuario);
        //esta parte es para elegir el nombre del html
        return "perfil";
    }

    //enviando una lista grande de datos a el html
    @GetMapping("/listar")
    public String listar(Model model){
        //lista creada para prueba if
        List<Usuario> usuarios = new ArrayList<>();

        //no habia mas imaginacion :c
        usuarios.add(new Usuario("Andres@gmail.com","Diaz","Andres"));
        usuarios.add(new Usuario("Mario@gmail.com","Diaz","Mario"));
        usuarios.add(new Usuario("Pedro@gmail.com","Diaz","Pedro"));

        model.addAttribute("titulo",textoListar);
        model.addAttribute("usuarios",usuarios);

        //use for each en el html con timeleaf pero no sabia poner comentarios :p
        return "listar";
    }


}
