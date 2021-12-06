package za.web.skerwe.adventofcode2021.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import za.web.skerwe.adventofcode2021.AdventDay;

public class Day04Test {

  private static final String TEST_INPUT_FILE_NAME = "src/test/resources/test-day04-p1.txt";
  private AdventDay dayTestClass;

  @BeforeEach
  public void initEach() {
    dayTestClass = new Day04();
  }

  //@Test
  public void testProcessPartOne() throws IOException, NumberFormatException {
    dayTestClass.setInputFileName(TEST_INPUT_FILE_NAME);
    String outputValue = dayTestClass.processPartOne();

    assertNotNull(outputValue);
    assertEquals("4512", outputValue);
  }

  //@Test
  public void testProcessPartTwo() throws IOException {
    dayTestClass.setInputFileName(TEST_INPUT_FILE_NAME);
    String outputValue = dayTestClass.processPartTwo();

    assertNotNull(outputValue);
    assertEquals("1924", outputValue);
  }

}
