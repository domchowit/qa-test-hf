package com.hellofresh.challenge.framework.model;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {

  private String email;
  private String name;
  private String surname;
  private String password;
  private LocalDate dateOfBirth;
  private String company;
  private String address;
  private String city;
  private String state;
  private Integer postCode;
  private String other;
  private String phone;
  private String phoneMobile;
  private String addressAlias;
}
