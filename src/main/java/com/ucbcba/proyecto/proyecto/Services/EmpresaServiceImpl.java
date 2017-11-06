package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Empresa;
import com.ucbcba.proyecto.proyecto.Repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private EmpresaRepository empresaRepository;

    @Autowired
    @Qualifier(value = "empresaRepository")
    public void setEmpresaRepository(EmpresaRepository empresaRepository){
        this.empresaRepository=empresaRepository;
    }


    @Override
    public Iterable<Empresa> listAllEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa getEmpresaById(Integer id) {
        return empresaRepository.findOne(id);
    }

    @Override
    public Empresa saveEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void deleteEmpresa(Integer id) {
        empresaRepository.delete(id);
    }
}
