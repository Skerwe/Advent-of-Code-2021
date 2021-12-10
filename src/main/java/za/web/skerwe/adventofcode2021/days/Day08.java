package za.web.skerwe.adventofcode2021.days;

import java.io.IOException;

import za.web.skerwe.adventofcode2021.AdventDay;
import za.web.skerwe.adventofcode2021.util.InputFileReader;

public class Day08 extends AdventDay {

  /**
   * Setup for the day's challenge (¬‿¬).
   */
  public Day08() {
    id = 8;
    name = "Day 8: Seven Segment Search";
    partOneDescription = "In the output values, how many times do digits 1, 4, 7, or 8 appear?";
    partTwoDescription = "What do you get if you add up all of the output values?";

    inputPart1 = "src/main/resources/input08-p1.txt";
  }

  @Override
  public String processPartOne() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);

    int totaluniqueNumberPatterns = 0;
    String[] uniqueSignalPattern;
    for (String line : input) {
      uniqueSignalPattern = line.split(" ");
      totaluniqueNumberPatterns += checkUniqueNumber(uniqueSignalPattern[11].length());
      totaluniqueNumberPatterns += checkUniqueNumber(uniqueSignalPattern[12].length());
      totaluniqueNumberPatterns += checkUniqueNumber(uniqueSignalPattern[13].length());
      totaluniqueNumberPatterns += checkUniqueNumber(uniqueSignalPattern[14].length());
    }

    return String.valueOf(totaluniqueNumberPatterns);
  }

  private int checkUniqueNumber(int size) {
    if (size == 2 || size == 4 || size == 3 || size == 7) {
      return 1;
    }
    return 0;
  }

  @Override
  public String processPartTwo() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);
    return null;
  }

}
