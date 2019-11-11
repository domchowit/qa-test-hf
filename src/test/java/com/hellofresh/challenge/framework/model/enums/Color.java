package com.hellofresh.challenge.framework.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Color {
  ORANGE("Orange"),
  BLUE("Blue");

  private static final List<Color> VALUES = Arrays.asList(values());
  private static final int LENGTH = VALUES.size();
  private static final Random RANDOM = new Random();
  private String color;

  Color(String color) {
    this.color = color;
  }

  public String color(){
    return this.color;
  }

  public static Color randomColor() {
    return VALUES.get(RANDOM.nextInt(LENGTH));
  }
}
