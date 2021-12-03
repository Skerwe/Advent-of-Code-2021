package za.web.skerwe.adventofcode2021.days;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import za.web.skerwe.adventofcode2021.AdventDay;

public class Day01Test {

  private static final String TEST_INPUT_FILE_NAME = "src/test/resources/test-day01-p1.txt";

  @Test
  public void testProcessPartOne() throws IOException {
    AdventDay dayTestClass = new Day01();
    dayTestClass.setInputFileName(TEST_INPUT_FILE_NAME);

    String outputValue = dayTestClass.processPartOne();

    assertNotNull(outputValue);
    assertEquals("7", outputValue);
  }

  @Test
  public void testProcessPartTwo() throws IOException {
    AdventDay dayTestClass = new Day01();
    dayTestClass.setInputFileName(TEST_INPUT_FILE_NAME);

    String outputValue = dayTestClass.processPartTwo();

    assertNotNull(outputValue);
    assertEquals("5", outputValue);
  }

}
