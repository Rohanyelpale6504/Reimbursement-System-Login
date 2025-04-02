package com.Login.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Login.dao.LoginReposiratory;
import com.Login.dto.LoginRequestDto;
import com.Login.exceptionhandling.LoginNotFoundException;
import com.Login.mapper.LoginMapper;
import com.Login.modul.Login;
import com.Login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginReposiratory loginRepository;

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public LoginRequestDto login(String username, String password) {
        // Fetch the user by username and password from the repository
        Login login = loginRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new LoginNotFoundException("Invalid username or password"));

        // Fetch the role from the Login entity
        String role = login.getRole();

        // Map the Login entity to a DTO and include the role
        LoginRequestDto loginRequestDto = loginMapper.toDto(login);
        loginRequestDto.setRole(role);  // Set the role in the DTO

        return loginRequestDto;
    }
}
