package com.codurance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorShould {

  private final StringCalculator stringCalculator = new StringCalculator();

  @ParameterizedTest
  @CsvSource(value = {
          "''; 0",
          "0, 0; 0",
          "1, 0; 1",
          "1,2,3,4,5,6,7,8,9; 45",
          "1001, 2; 2",
          "'1\n2,3'; 6",
          "'//;\n1;2'; 3",
          "'//[***]\n1***2***3'; 6",
          "'//[foo][bar]\n1foo2bar3'; 6",
          "'//[*][%]\n1*2%3'; 6"
  }, delimiter = ';')
  void return_correct_addition_output_for_string_numbers(String input, int output) {
    assertEquals(output, stringCalculator.add(input));
  }

  @Test
  void throws_exception_for_input_less_than_zero() {
    assertThrows(IllegalArgumentException.class, () -> {
      stringCalculator.add("1,-2,-3");
    });
  }
}
