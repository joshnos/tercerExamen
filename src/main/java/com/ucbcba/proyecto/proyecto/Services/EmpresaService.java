package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Empresa;

public interface EmpresaService {

    Iterable<Empresa> listAllEmpresas();

    Empresa getEmpresaById(Integer id);

    Empresa saveEmpresa(Empresa empresa);

    void deleteEmpresa(Integer id);
}
