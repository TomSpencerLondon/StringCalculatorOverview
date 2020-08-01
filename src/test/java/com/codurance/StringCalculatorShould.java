package com.codurance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorShould {
  @ParameterizedTest
  @CsvSource(value = {
          "0, 0; 0",
          "1, 0; 1"
  }, delimiter = ';')
  void return_correct_addition_output_for_string_numbers(String input, int output) {
    StringCalculator stringCalculator = new StringCalculator();
    assertEquals(output, stringCalculator.add(input));
  }
}
