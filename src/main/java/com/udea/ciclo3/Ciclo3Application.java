package com.udea.ciclo3;

import com.udea.ciclo3.dominio.Empresa;
import net.minidev.json.JSONUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.SchemaOutputResolver;

@RestController
@SpringBootApplication (exclude ={SecurityAutoConfiguration.class})

public class Ciclo3Application {
    @GetMapping("/hola")
    public String hola() {
        return "Hola este es el primer saludo web";
    }

    public static void main(String[] args) {
        SpringApplication.run(Ciclo3Application.class, args);
        System.out.println("Hola mundo nuevo hoy actualizacion");
        Empresa emp = new Empresa("Casa Villa","calle 35#3-55","3205669877","893652221");
        emp.setNombre("Casa Cuervo");
        System.out.println(emp.toString());

    }

    @GetMapping("/test")
    public String test() {
        Empresa emp = new Empresa("Casa Villa","calle 35#3-55","3205669877","893652221");
        emp.setNombre("Casa Cuervo");
        return emp.toString();
    }


}
