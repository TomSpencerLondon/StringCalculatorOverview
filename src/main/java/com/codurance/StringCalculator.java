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
      regex.append(";");
    }

  return Arrays.stream(input.split("[" + regex + "]"))
          .map(String::strip)
          .mapToInt(Integer::parseInt)
          .peek(n -> {
            if (n < 0) throw new IllegalArgumentException("Negatives not allowed");
          }).sum();
  }
}
