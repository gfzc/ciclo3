package com.udea.ciclo3.services;

import com.udea.ciclo3.entities.Empresa;
import com.udea.ciclo3.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {

    @Autowired //conecta la clase con el repository de empresa
    EmpresaRepository empresaRepository; //Crea objeto de tipo empresaRepository para usar metodos

    //Metodo que retorna lista de empresas con metodos heredados del jpa Repository
    public List<Empresa> getAllEmpresas(){
        List <Empresa> empresaList= new ArrayList<>();
        empresaRepository.findAll().forEach(Empresa -> empresaList.add(Empresa)); //Recorre iterable que regresa metodo finAll y lo guarda en lista empresa

        return empresaList;

    }
    //Metodo que trae objeto tipo Empresa cuando cuento con el id de la misma
    public Empresa getEmpresaById(Long id){

        return empresaRepository.findById(id).get();
    }

    //Metodo para guardar o actualizar objetos de tipo Empresa
    public boolean saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp = empresaRepository.save(empresa);
            if (empresaRepository.findById(emp.getIdEmpresa())!=null) {
                return true;
            }
            return false;

    }

    //Metodo para eliminar objetos de tipo Empresa

}
