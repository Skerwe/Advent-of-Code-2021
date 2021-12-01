package za.web.skerwe.adventofcode2021.days;

import org.junit.jupiter.api.Test;

import za.web.skerwe.adventofcode2021.AdventDay;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class Day01Test {

  private static final String TEST_INPUT_FILE_NAME = "src/test/resources/test-day01-p1.txt";

  @Test
  public void testProcessPartOne() throws IOException {
    AdventDay dayTestClass = new Day01();
    dayTestClass.setInputFileNamePartOne(TEST_INPUT_FILE_NAME);

    String outputValue = dayTestClass.processPartOne();

    assertTrue(outputValue != null);
    assertEquals(outputValue, "7");
  }

  @Test
  public void testProcessPartTwo() throws IOException {
    AdventDay dayTestClass = new Day01();
    dayTestClass.setInputFileNamePartTwo(TEST_INPUT_FILE_NAME);

    String outputValue = dayTestClass.processPartTwo();

    assertTrue(outputValue != null);
    assertEquals(outputValue, "5");
  }

}
