package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Role;

public interface RolesService {
    Iterable<Role> listAllOptions();
    Role getRoleById(Integer id);
    Role saveOption(Role role);
    void deleteOption(Integer id);
}
