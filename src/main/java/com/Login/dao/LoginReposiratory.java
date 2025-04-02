package com.Login.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Login.modul.Login;
@Repository
public interface LoginReposiratory extends JpaRepository<Login, Long>{
	 Optional<Login> findByUsernameAndPassword(String username, String password);
}
