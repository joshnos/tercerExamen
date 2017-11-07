package com.ucbcba.proyecto.proyecto.Services;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}