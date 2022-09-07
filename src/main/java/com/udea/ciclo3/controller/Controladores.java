package com.udea.ciclo3.controller;

import com.udea.ciclo3.entities.Empresa;
import com.udea.ciclo3.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class Controladores {
    @Autowired //Inyeccion de metodos con services
    EmpresaService empresaService; //Creo objeto de tipo EmpresaService para usar metodos del servicio creado

    @GetMapping({"/","/VerEmpresas"}) //Anotacion que mapea y crea el servicio VerEmpresas
    public String viewEmpresas(Model model){ //Metodo para obtener cadenas de empresas con objeto de clase tipo Model, recibe cualquiercosa y modela segun lo necesitado
        List <Empresa> listEmpresas = empresaService.getAllEmpresas(); //Se crea lista de tipo Empresas con el metodo getAllEmpresas
        model.addAttribute("emplist", listEmpresas); //Sa alimenta objeto model con lista de empresas
        return "verEmpresas"; //LLama a pagina html creada
    }

    @GetMapping({"/AgregarEmpresa"}) //Anotacion que mapea y crea el servicio AgregarEmpresa obtener informacion
    public String newEmpresa(Model model){ //Inserta objeto model
        Empresa nuevaEmp = new Empresa(); //Crea objeto de tipo Empresa para crear la nueva empresa utilizando el constructor vacio
        model.addAttribute("newEmpn", nuevaEmp); //Envia el objeto por medio de model
        return "agregarEmpresas"; //LLama a pagina html creada

    }

    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa nuevaEmp, RedirectAttributes redirectAttributes){
        if (empresaService.saveOrUpdateEmpresa(nuevaEmp)==true){
            return "redirect:/VerEmpresas";
        }
        return "redirect:/AgregarEmpresa";


    }




}
