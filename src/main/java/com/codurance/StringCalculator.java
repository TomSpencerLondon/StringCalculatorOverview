package com.codurance;

import java.util.Arrays;

public class StringCalculator {
  public int add(String input) {
    StringBuilder regex = new StringBuilder("\\n,");

    if (input.length() < 1) {
      return 0;
    }

    if (input.startsWith("//")){
      regex.append(input.substring(input.indexOf("//"), input.indexOf("\n")));
      regex.toString().replaceAll("\\[\\]", "");
      input = input.substring(input.indexOf("\n")).trim();
//      regex.append(";***");
    }

  return Arrays.stream(input.split("[" + regex + "]"))
          .map(String::strip)
          .filter(i -> !i.isBlank())
          .mapToInt(Integer::parseInt)
          .filter(n -> n <= 1000)
          .peek(n -> {
            if (n < 0) throw new IllegalArgumentException("Negatives not allowed");
          }).sum();
  }
}
