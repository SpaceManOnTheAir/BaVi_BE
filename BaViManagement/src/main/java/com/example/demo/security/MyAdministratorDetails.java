package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdministratorRepository;
import com.example.demo.entity.Administrator;


@Service
public class MyAdministratorDetails implements UserDetailsService {

  @Autowired
  private AdministratorRepository studentRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final Administrator admins = studentRepository.findByUsername(username);

    if (admins == null) {
      throw new UsernameNotFoundException("User '" + username + "' not found");
    }

    return User//
        .withUsername(username)//
        .password(admins.getPassword())//
        .authorities(admins.getRoles())//
        .accountExpired(false)//
        .accountLocked(false)//
        .credentialsExpired(false)//
        .disabled(false)//
        .build();
  }

}
