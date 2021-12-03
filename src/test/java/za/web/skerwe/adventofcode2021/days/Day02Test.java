package za.web.skerwe.adventofcode2021.days;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import za.web.skerwe.adventofcode2021.AdventDay;

public class Day02Test {

  private static final String TEST_INPUT_FILE_NAME = "src/test/resources/test-day02-p1.txt";

  @Test
  public void testProcessPartOne() throws IOException {
    AdventDay dayTestClass = new Day02();
    dayTestClass.setInputFileName(TEST_INPUT_FILE_NAME);

    String outputValue = dayTestClass.processPartOne();

    assertNotNull(outputValue);
    assertEquals("150", outputValue);
  }

  @Test
  public void testProcessPartTwo() throws IOException {
    AdventDay dayTestClass = new Day02();
    dayTestClass.setInputFileName(TEST_INPUT_FILE_NAME);

    String outputValue = dayTestClass.processPartTwo();

    assertNotNull(outputValue);
    assertEquals("900", outputValue);
  }

}