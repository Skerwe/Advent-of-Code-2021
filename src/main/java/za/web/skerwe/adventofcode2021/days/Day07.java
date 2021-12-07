package za.web.skerwe.adventofcode2021.days;

import java.io.IOException;

import za.web.skerwe.adventofcode2021.AdventDay;
import za.web.skerwe.adventofcode2021.util.InputFileReader;

public class Day07 extends AdventDay {

  /**
   * Setup for the day's challenge (¬‿¬).
   */
  public Day07() {
    id = 7;
    name = "Day 7: The Treachery of Whales";
    partOneDescription = "The horizontal position using the least fuel possible";
    partTwoDescription = "The horizontal position using crab engineering";

    inputPart1 = "src/main/resources/input07-p1.txt";
  }

  @Override
  public String processPartOne() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);
    int[] crabs = initialize(input[0].split(","));

    int total = 0;

    for (int index = 0; index < crabs.length; index++) {
      total = total + crabs[index];
    }

    int average = total / crabs.length;

    int fuel = calculateLeastFuelPossible(crabs, average);
    return String.valueOf(fuel);
  }

  @Override
  public String processPartTwo() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);
    int[] crabs = initialize(input[0].split(","));

    long fuel = calculateLeastFuelPossibleCrabEngineering(crabs);
    return String.valueOf(fuel);
  }

  private int[] initialize(String[] input) {
    int[] crabs = new int[input.length];
    int total = 0;

    for (int index = 0; index < input.length; index++) {
      total = total + Integer.valueOf(input[index]);
      crabs[index] = Integer.valueOf(input[index]);
    }

    return crabs;
  }

  private int calculateLeastFuelPossible(int[] crabs, int target) {
    int fuel = calculateFuelConsumption(crabs, target);
    int up = calculateFuelConsumption(crabs, target + 1);
    int down = calculateFuelConsumption(crabs, target - 1);

    if (down > up && up < fuel) {
      return calculateLeastFuelPossible(crabs, target + 1);
    } else if (up > down && down < fuel) {
      return calculateLeastFuelPossible(crabs, target - 1);
    } else {
      return fuel;
    }
  }

  private int calculateFuelConsumption(int[] crabs, int target) {
    int fuel = 0;
    for (int index = 0; index < crabs.length; index++) {
      fuel = fuel + Math.abs(crabs[index] - target);
    }
    return fuel;
  }

  private long calculateLeastFuelPossibleCrabEngineering(int[] crabs) {
    long[] fuelConsumption = new long[crabs.length];

    for (int index = 0; index < crabs.length; index++) {
      fuelConsumption[index] = calculateFuelConsumptionCrabEngineering(crabs, index);
    }

    long fuel = fuelConsumption[0];
    for (int index = 0; index < fuelConsumption.length; index++) {
      if (fuelConsumption[index] < fuel) {
        fuel = fuelConsumption[index];
      }
    }

    return fuel;
  }

  /**
   * https://math.stackexchange.com/questions/1908152/how-to-calculate-the-sum-of-an-incremental-string-of-numbers
   */
  private int calculateFuelConsumptionCrabEngineering(int[] crabs, int target) {
    int fuel = 0;
    int step = 0;
    for (int index = 0; index < crabs.length; index++) {
      step = Math.abs(crabs[index] - target);
      fuel = fuel + (step * (step + 1)) / 2;
    }
    return fuel;
  }

}
