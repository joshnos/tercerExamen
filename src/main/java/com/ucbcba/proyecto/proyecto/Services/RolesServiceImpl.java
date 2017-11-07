package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Role;
import com.ucbcba.proyecto.proyecto.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService{

    private RoleRepository roleRepository;

    @Autowired
    @Qualifier(value = "roleRepository")
    public void setRoleRepository(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    @Override
    public Iterable<Role> listAllOptions() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role saveOption(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteOption(Integer id) {
        roleRepository.delete(id);

    }
}
