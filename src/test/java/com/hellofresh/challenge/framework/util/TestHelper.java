package com.hellofresh.challenge.framework.util;

import com.hellofresh.challenge.framework.configuration.ConfigFeeder;
import com.hellofresh.challenge.framework.model.Order;
import com.hellofresh.challenge.framework.model.User;
import com.hellofresh.challenge.framework.model.enums.Color;
import com.hellofresh.challenge.framework.model.enums.Size;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;

public class TestHelper {

  private static String email = ConfigFeeder.INSTANCE.config.getString("maven.user.email");
  private static String password = ConfigFeeder.INSTANCE.config.getString("maven.user.password");
  private static String name = ConfigFeeder.INSTANCE.config.getString("maven.user.name");
  private static String surname = ConfigFeeder.INSTANCE.config.getString("maven.user.surname");

  public static User generateRandomUser() {
    return User.builder()
        .name(getRandomString(10))
        .surname(getRandomString(10))
        .email(generateRandomEmail())
        .password(getRandomString(10, true, true))
        .dateOfBirth(createRandomDate(1900, 2000))
        .company(getRandomString(10))
        .address(getRandomString(10))
        .city(getRandomString(10))
        .state("Colorado")
        .postCode(createRandomIntBetween(10000, 99999))
        .phone(getRandomString(10, false, true))
        .phoneMobile(getRandomString(10, false, true))
        .other(getRandomString(10))
        .addressAlias(getRandomString(10))
        .build();
  }

  public static Order generateRandomOrder(){
    return Order.builder().color(Color.randomColor()).size(Size.randomSize()).build();
  }

  public static User generateExistingUser() {
    return User.builder().name(name).surname(surname).email(email).password(password).build();
  }


  public static LocalDate createRandomDate(int startYear, int endYear) {
    int day = createRandomIntBetween(1, 28);
    int month = createRandomIntBetween(1, 12);
    int year = createRandomIntBetween(startYear, endYear);
    return LocalDate.of(year, month, day);
  }

  public static int createRandomIntBetween(int start, int end) {
    return start + (int) Math.round(Math.random() * (end - start));
  }

  private static String generateRandomEmail() {
    String timestamp = String.valueOf(new Date().getTime());
    return "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
  }

  static public String getRandomString(int length, boolean useLetters, boolean useNumbers) {
    return RandomStringUtils.random(length, useLetters, useNumbers);
  }

  static public String getRandomString(int length) {
    return RandomStringUtils.random(length, true, false);
  }

}
