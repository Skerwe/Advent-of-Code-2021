package za.web.skerwe.adventofcode2021.days;

import java.io.IOException;
import java.util.ArrayList;

import za.web.skerwe.adventofcode2021.AdventDay;
import za.web.skerwe.adventofcode2021.util.InputFileReader;

public class Day01 extends AdventDay {

  /**
   * Setup for the day's challenge (¬‿¬).
   */
  public Day01() {
    id = 1;
    name = "Day 1: Sonar Sweep";
    partOneDescription = "The number of times a depth measurement increases";
    partTwoDescription = "The number of times the sum of measurements in the sliding window increases";

    inputPart1 = "src/main/resources/input01-p1.txt";
  }

  @Override
  public String processPartOne() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);

    return String.valueOf(calculateDepthMeasurementIncreases(input));
  }

  @Override
  public String processPartTwo() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);

    ArrayList<String> inputGrouped = new ArrayList<>();
    createThreeMeasurementGroup(inputGrouped, input, 0);

    if (inputGrouped.isEmpty()) {
      return "error 5000 ლ(ಠ益ಠლ)";
    }

    return String.valueOf(calculateDepthMeasurementIncreases(inputGrouped.toArray(input)));
  }

  private int calculateDepthMeasurementIncreases(String[] input) {
    int previousDepth = Integer.parseInt(input[0]);
    int numberOfTimesDepthIncreases = 0;

    for (String line : input) {
      int depth = Integer.parseInt(line);
      if (depth > previousDepth) {
        numberOfTimesDepthIncreases = numberOfTimesDepthIncreases + 1;
      }
      previousDepth = depth;
    }

    return numberOfTimesDepthIncreases;
  }

  private void createThreeMeasurementGroup(ArrayList<String> inputGrouped, String[] input, int index) {
    if (index < input.length) {

      int measurement = Integer.parseInt(input[index]);

      if (index + 1 < input.length) {
        measurement += Integer.parseInt(input[index + 1]);
      }

      if (index + 2 < input.length) {
        measurement += Integer.parseInt(input[index + 2]);
      }

      inputGrouped.add(String.valueOf(measurement));

      createThreeMeasurementGroup(inputGrouped, input, index + 1);
    }
  }
}
