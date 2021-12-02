package za.web.skerwe.adventofcode2021.days;

import org.junit.jupiter.api.Test;

import za.web.skerwe.adventofcode2021.AdventDay;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class Day02Test {

  private static final String TEST_INPUT_FILE_NAME = "src/test/resources/test-day02-p1.txt";

  @Test
  public void testProcessPartOne() throws IOException {
    AdventDay dayTestClass = new Day02();
    dayTestClass.setInputFileNamePartOne(TEST_INPUT_FILE_NAME);

    String outputValue = dayTestClass.processPartOne();

    assertTrue(outputValue != null);
    assertEquals(outputValue, "150");
  }

  @Test
  public void testProcessPartTwo() throws IOException {
    AdventDay dayTestClass = new Day02();
    dayTestClass.setInputFileNamePartTwo(TEST_INPUT_FILE_NAME);

    String outputValue = dayTestClass.processPartTwo();

    assertTrue(outputValue != null);
    assertEquals(outputValue, "900");
  }

}
