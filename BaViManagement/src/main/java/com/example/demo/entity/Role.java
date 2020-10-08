package com.example.demo.entity;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  ROLE_ADMIN, ROLE_INSTRUCTOR,
  ROLE_STUDENT;

  public String getAuthority() {
    return name();
  }

}
