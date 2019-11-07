package com.hellofresh.challenge.framework.util;

public enum ExpectedTranslations {
  MY_ACCOUNT_HEADER("MY ACCOUNT"),
  MY_ACCOUNT_WELCOME("Welcome to your account."),
  MY_ACCOUNT_URL("controller=my-account"),
  ORDER_CONFIRMATION_HEADING("ORDER CONFIRMATION"),
  ORDER_CONFIRMATION_SUMMARY_TITLE("Your order on My Store is complete.");

  private String translation;

  ExpectedTranslations(String translation) {
    this.translation = translation;
  }

  public String translation() {
    return translation;
  }


}
