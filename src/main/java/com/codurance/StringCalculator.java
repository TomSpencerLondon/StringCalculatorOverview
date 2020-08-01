package com.codurance;

public class StringCalculator {
  public int add(String input) {
    return Integer.parseInt(input.split(",")[0])
            + Integer.parseInt(input.split(",")[1].trim());
  }
}
