package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Administrator;
import com.example.demo.entity.Role;
import com.example.demo.service.AdministratorService;

@SpringBootApplication
public class BaViManagementApplication  implements CommandLineRunner{
	@Autowired
	AdministratorService adminService;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(BaViManagementApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//		Administrator admin = new Administrator();
//		admin.setEmail("thuyennguyenphi@gmail.com");
//		admin.setFirstName("Thuyen");
//		admin.setLastName("Nguyen");
//	
//		admin.setUsername("admin");
//		admin.setPassword("password");
//		admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));
//		adminService.signup(admin);
	}

}
