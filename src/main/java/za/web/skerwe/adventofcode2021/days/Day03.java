package za.web.skerwe.adventofcode2021.days;

import java.io.IOException;
import java.util.ArrayList;

import za.web.skerwe.adventofcode2021.AdventDay;
import za.web.skerwe.adventofcode2021.util.InputFileReader;

public class Day03 extends AdventDay {

  /**
   * Setup for the day's challenge (¬‿¬).
   */
  public Day03() {
    id = 3;
    name = "Day 3: Binary Diagnostic";
    partOneDescription = "Power consumption of the submarine";
    partTwoDescription = "Life support rating";

    inputPart1 = "src/main/resources/input03-p1.txt";
  }

  @Override
  public String processPartOne() throws IOException, NumberFormatException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);
    return determinePowerConsumption(input);
  }

  @Override
  public String processPartTwo() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);
    return determineLifeSupportRating(input);
  }

  private String determinePowerConsumption(String[] input) throws NumberFormatException {
    int powerConsumption = 0;
    String mostCommonBits = "";
    String leastCommonBits = "";

    for (int index = 0; index < input[0].length(); index++) {
      int[] commonBits = getMostCommonBits(input, index);
      mostCommonBits += commonBits[0];
      leastCommonBits += commonBits[1];
    }

    int gammaRate = Integer.parseInt(mostCommonBits, 2);
    int epsilonRate = Integer.parseInt(leastCommonBits, 2);
    powerConsumption = gammaRate * epsilonRate;

    return String.valueOf(powerConsumption);
  }

  private int[] getMostCommonBits(String[] input, int index) {
    int[] commonBits = new int[2];
    int ones = 0;
    int zeros = 0;

    for (String line : input) {
      if (line.charAt(index) == '1') {
        ones = ones + 1;
      } else {
        zeros = zeros + 1;
      }
    }

    if (ones == zeros || ones > zeros) {
      commonBits[0] = 1;
      commonBits[1] = 0;
    } else {
      commonBits[0] = 0;
      commonBits[1] = 1;
    }

    return commonBits;
  }

  private String determineLifeSupportRating(String[] input) throws NumberFormatException {
    ArrayList<String> mostCommonBits = new ArrayList<>();
    ArrayList<String> leastCommonBits = new ArrayList<>();

    int index = 0;

    int[] commonBits = getMostCommonBits(input, index);
    for (String line : input) {
      if (line.charAt(index) == (commonBits[0] + '0')) {
        mostCommonBits.add(line);
      } else {
        leastCommonBits.add(line);
      }
    }

    if (mostCommonBits.isEmpty() || leastCommonBits.isEmpty()) {
      return "error 5000 ლ(ಠ益ಠლ)";
    }

    String oxygenGeneratorRating = filterForNumbers(mostCommonBits, index + 1, true);
    String co2ScrubberRating = filterForNumbers(leastCommonBits, index + 1, false);

    int lifeSupportRating = Integer.parseInt(oxygenGeneratorRating, 2) * Integer.parseInt(co2ScrubberRating, 2);

    return String.valueOf(lifeSupportRating);
  }

  private String filterForNumbers(ArrayList<String> numbers, int index, boolean isForMostBits) {
    ArrayList<String> filteredNumbers = new ArrayList<>();
    int[] commonBits = getMostCommonBits(numbers.toArray(new String[0]), index);

    for (String line : numbers) {
      if (line.charAt(index) == (isForMostBits ? commonBits[0] : commonBits[1]) + '0') {
        filteredNumbers.add(line);
      }
    }

    if (filteredNumbers.size() == 1) {
      return filteredNumbers.get(0);
    } else {
      return filterForNumbers(filteredNumbers, index + 1, isForMostBits);
    }
  }

}
