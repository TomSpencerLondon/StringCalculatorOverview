package com.codurance;

public class StringCalculator {
  public int add(String input) {
    if(input.length() < 1){
      return 0;
    }
    return Integer.parseInt(input.split(",")[0])
            + Integer.parseInt(input.split(",")[1].trim());
  }
}
