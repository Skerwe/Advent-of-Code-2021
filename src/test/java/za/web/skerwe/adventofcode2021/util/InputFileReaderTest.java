package za.web.skerwe.adventofcode2021.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class InputFileReaderTest {

  private static final String TEST_INPUT_FILE_NAME = "src/test/resources/test-inputreader-file.txt";
  private static final String TEST_BLANK_INPUT_FILE_NAME = "src/test/resources/test-blank-inputreader-file.txt";

  @Test
  public void testReadInputFile() throws IOException {
    String[] lines = InputFileReader.readInputFile(TEST_INPUT_FILE_NAME);
    assertTrue(lines != null);
    assertEquals(lines.length, 3);
  }

  @Test
  public void testReadInputFileBlank() throws IOException {
    String[] lines = InputFileReader.readInputFile(TEST_BLANK_INPUT_FILE_NAME);
    assertTrue(lines != null);
    assertEquals(lines.length, 0);
  }

}
