package com.Login.mapper;

import org.springframework.stereotype.Component;

import com.Login.dto.LoginRequestDto;
import com.Login.modul.Login;

@Component
public class LoginMapper {

    public LoginRequestDto toDto(Login login) {
        if (login == null) {
            return null;
        }
        LoginRequestDto dto = new LoginRequestDto();
        dto.setUsername(login.getUsername());
        dto.setPassword(login.getPassword()); // ⚠️ Consider removing this for security
        return dto;
    }

    public Login toEntity(LoginRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Login login = new Login();
        login.setUsername(dto.getUsername());
        login.setPassword(dto.getPassword()); // ⚠️ Consider encrypting password before saving
        return login;
    }
}
