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
          "1, 0; 1"
  }, delimiter = ';')
  void return_correct_addition_output_for_string_numbers(String input, int output) {
    assertEquals(output, stringCalculator.add(input));
  }

  @Test
  void add_an_arbitrary_amount_of_numbers() {
    assertEquals(45, stringCalculator.add("1,2,3,4,5,6,7,8,9"));
  }

  @Test
  void returns_correct_output_with_newline_input() {
    assertEquals(6, stringCalculator.add("1\n2,3"));
  }

  @Test
  void returns_correct_output_with_custom_separators() {
    assertEquals(3, stringCalculator.add("//;\n1;2"));
  }

  @Test
  void throws_exception_for_input_less_than_zero() {
    assertThrows(IllegalArgumentException.class, () -> {
      stringCalculator.add("1,-2,-3");
    });
  }

  @Test
  void ignore_numbers_more_than_1000() {
    assertEquals(2, stringCalculator.add("1001, 2"));
  }

  @Test
  void adds_numbers_with_arbitrary_length_separators() {
    assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
  }
}
