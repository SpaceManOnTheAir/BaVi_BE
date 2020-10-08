package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdministratorRepository;
import com.example.demo.dto.Tokenizer;
import com.example.demo.entity.Administrator;
import com.example.demo.exception.CustomException;
import com.example.demo.security.JwtTokenProvider;

@Service
public class AdministratorService {

	@Autowired
	private AdministratorRepository repo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	public Tokenizer signin(String username, String password) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			Tokenizer tokenizer = new Tokenizer();
			tokenizer.setToken("Bearer "+jwtTokenProvider.createToken(username, repo.findByUsername(username).getRoles()));
			return tokenizer;
			
			
		} catch (AuthenticationException e) {
			throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	public String signup(Administrator admin) {
		    if (!repo.existsByUsername(admin.getUsername())) {
		    	admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		      repo.save(admin);
		      return jwtTokenProvider.createToken(admin.getUsername(), admin.getRoles());
		    } else {
		      throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
		    }
		  }
	  
	  public List<Administrator> getAllStudents(){
		  return repo.findAll();
	  }
	  
	  public Administrator createAStudent ( Administrator aStudent) {
		  return  repo.save(aStudent);
	  }
	  
	  public Administrator updateAStudent (Integer id,  Administrator aStudent) throws Exception {
		  Administrator updateStudent = getAnAdmin(id);
		  updateStudent.setDOB(aStudent.getDOB());
		  updateStudent.setEmail(aStudent.getEmail());
		  updateStudent.setFirstName(aStudent.getFirstName());
		  updateStudent.setLastName(aStudent.getLastName());
		  return  repo.save(aStudent);
	  }
	  
	  public Administrator getAnAdmin ( Integer id) throws Exception {
		  return  repo.findById(id).orElseThrow(() ->  new Exception("Cannot find"));
	  }
}
