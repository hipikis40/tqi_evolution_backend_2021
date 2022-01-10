package com.clientes.emprestimos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.authorization.method.SecuredAuthorizationManager;

@SpringBootApplication
public class EmprestimosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmprestimosApplication.class, args);
	}


}
