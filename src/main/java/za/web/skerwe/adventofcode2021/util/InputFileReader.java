package za.web.skerwe.adventofcode2021.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class InputFileReader {

  private InputFileReader() {
  }

  /**
   * Read a text file into an array of strings.
   * The input files are under <code>src/main/resources</code>
   *
   * @param fileName the file name to read
   * @return an array of strings representing each line in the file
   * @throws IOException when the file cannot be found
   */
  public static String[] readInputFile(String fileName) throws IOException {
    List<String> lines = new ArrayList<>();

    BufferedReader inputStream = new BufferedReader(new FileReader(fileName));

    String line;
    while ((line = inputStream.readLine()) != null) {
      lines.add(line);
    }

    inputStream.close();

    return lines.toArray(new String[0]);
  }
}
