package com.practica1.practica;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        //aca se puede agregar mas properties para guardar cositas
    @PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {

}
