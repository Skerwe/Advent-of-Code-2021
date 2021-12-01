package za.web.skerwe.adventofcode2021.days;

import java.io.IOException;
import java.util.ArrayList;

import za.web.skerwe.adventofcode2021.AdventDay;
import za.web.skerwe.adventofcode2021.util.InputFileReader;

public class Day01 implements AdventDay {

  private String INPUT_PART_1 = "src/main/resources/input01-p1.txt";

  @Override
  public String processPartOne() {
    String[] input = {};
    try {
      input = InputFileReader.readInputFile(this.INPUT_PART_1);
    } catch (IOException exception) {
      exception.printStackTrace();
    }

    if (input.length == 0) {
      return "error 100/3 ಠ╭╮ಠ";
    }

    return String.valueOf(calculateDepthMeasurementIncreases(input));
  }

  @Override
  public String processPartTwo() {
    String[] input = {};
    try {
      input = InputFileReader.readInputFile(this.INPUT_PART_1);
    } catch (IOException exception) {
      exception.printStackTrace();
    }

    if (input.length == 0) {
      return "error 100/3 ಠ╭╮ಠ";
    }

    ArrayList<String> inputGrouped = new ArrayList<>();
    createThreeMeasurementGroup(inputGrouped, input, 0);

    if (inputGrouped.size() == 0) {
      return "error 5000 ლ(ಠ益ಠლ)";
    }

    return String.valueOf(calculateDepthMeasurementIncreases(inputGrouped.toArray(input)));
  }

  @Override
  public void setInputFileNamePartOne(String fileName) {
    this.INPUT_PART_1 = fileName;
  }

  @Override
  public void setInputFileNamePartTwo(String fileName) {
    this.INPUT_PART_1 = fileName;
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
