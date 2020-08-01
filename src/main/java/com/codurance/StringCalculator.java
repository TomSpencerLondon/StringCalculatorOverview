package com.codurance;

import java.util.Arrays;

public class StringCalculator {
  public int add(String input) {
    StringBuilder regex = new StringBuilder("\\n,");
    if (input.length() < 1) {
      return 0;
    }
    if (input.startsWith("//")){
      input = input.substring(input.indexOf("\n")).trim();
      System.out.println(input);
      regex.append(";");
    }

  return Arrays.stream(input.split("[" + regex + "]"))
          .map(String::strip)
          .mapToInt(Integer::parseInt).sum();
  }
}
