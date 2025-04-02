package com.Login.service;

import org.springframework.stereotype.Service;

import com.Login.dto.LoginRequestDto;

@Service
public interface LoginService {
	
	LoginRequestDto login(String username,String password);

}
