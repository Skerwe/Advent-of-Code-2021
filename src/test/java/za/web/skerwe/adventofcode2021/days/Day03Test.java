package za.web.skerwe.adventofcode2021.days;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import za.web.skerwe.adventofcode2021.AdventDay;

public class Day03Test {

  private static final String TEST_INPUT_FILE_NAME = "src/test/resources/test-day03-p1.txt";

  @Test
  public void testProcessPartOne() throws IOException, NumberFormatException {
    AdventDay dayTestClass = new Day03();
    dayTestClass.setInputFileName(TEST_INPUT_FILE_NAME);

    String outputValue = dayTestClass.processPartOne();

    assertNotNull(outputValue);
    assertEquals("198", outputValue);
  }

  @Test
  public void testProcessPartTwo() throws IOException {
    AdventDay dayTestClass = new Day03();
    dayTestClass.setInputFileName(TEST_INPUT_FILE_NAME);

    String outputValue = dayTestClass.processPartTwo();

    assertNotNull(outputValue);
    assertEquals("230", outputValue);
  }

}
