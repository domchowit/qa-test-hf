package com.hellofresh.challenge.framework.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Size {
  SMALL("S"),
  MEDIUM("M"),
  LARGE("L");

  private static final List<Size> VALUES = Arrays.asList(values());
  private static final int LENGTH = VALUES.size();
  private static final Random RANDOM = new Random();
  private String size;

  Size(String size) {
    this.size = size;
  }
  public String size(){
    return this.size;
  }

  public static Size randomSize() {
    return VALUES.get(RANDOM.nextInt(LENGTH));
  }
}
