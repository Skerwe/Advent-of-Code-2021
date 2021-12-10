package za.web.skerwe.adventofcode2021.days;

import java.io.IOException;

import za.web.skerwe.adventofcode2021.AdventDay;
import za.web.skerwe.adventofcode2021.util.InputFileReader;

public class Day06 extends AdventDay {

  /**
   * Setup for the day's challenge (¬‿¬).
   */
  public Day06() {
    id = 6;
    name = "Lanternfish";
    partOneDescription = "How many lanternfish would there be after 80 days?";
    partTwoDescription = "How many lanternfish would there be after 256 days?";

    inputPart1 = "src/main/resources/input06-p1.txt";
  }

  @Override
  public String processPartOne() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);

    return String.valueOf(simulate(initialize(input[0].split(",")), 80));
  }

  @Override
  public String processPartTwo() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);

    return String.valueOf(simulate(initialize(input[0].split(",")), 256));
  }

  private long[] initialize(String[] input) {
    long[] lanternfish = new long[9];
    for (int index = 0; index < input.length; index++) {
      lanternfish[Integer.valueOf(input[index])]++;
    }

    return lanternfish;
  }

  private long simulate(long[] lanternfish, int days) {
    long newFish;

    for (int d = 0; d < days; d++) {

      newFish = lanternfish[0];
      for (int index = 1; index < lanternfish.length; index++) {
        lanternfish[index - 1] = lanternfish[index];
      }
      lanternfish[lanternfish.length - 1] = newFish;
      lanternfish[6] += newFish;
    }

    long total = 0L;
    for (int index = 0; index < lanternfish.length; index++) {
      total = total + lanternfish[index];
    }

    return total;
  }
}
