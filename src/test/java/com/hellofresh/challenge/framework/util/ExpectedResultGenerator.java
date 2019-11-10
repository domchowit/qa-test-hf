package com.hellofresh.challenge.framework.util;

import com.hellofresh.challenge.framework.model.User;

public class ExpectedResultGenerator {

  public static String getHeaderMyAcountText(User user) {
    return user.getName() + " " + user.getSurname();
  }
}
