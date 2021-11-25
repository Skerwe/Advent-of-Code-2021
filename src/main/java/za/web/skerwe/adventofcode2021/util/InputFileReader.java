package za.web.skerwe.adventofcode2021.util;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class InputFileReader {

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
