package za.web.skerwe.adventofcode2021.days;

import java.io.IOException;

import za.web.skerwe.adventofcode2021.AdventDay;
import za.web.skerwe.adventofcode2021.util.InputFileReader;

public class Day02 extends AdventDay {

  /**
   * Setup for the day's challenge (¬‿¬).
   */
  public Day02() {
    id = 2;
    name = "Day 2: Dive!";
    partOneDescription = "Multiplying final horizontal position by the final depth";
    partTwoDescription = "Multiplying final horizontal position by the final depth";

    inputPart1 = "src/main/resources/input02-p1.txt";
  }

  @Override
  public String processPartOne() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);

    return String.valueOf(calculateDepthAfterDive(input));
  }

  @Override
  public String processPartTwo() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);

    return String.valueOf(calculateDepthAfterDiveWithAim(input));
  }

  private int calculateDepthAfterDive(String[] input) {
    int horizontal = 0;
    int depth = 0;

    for (String line : input) {
      String[] moveInstruction = line.split(" ");
      switch (moveInstruction[0]) {
        case "forward": {
          horizontal += Integer.parseInt(moveInstruction[1]);
          break;
        }
        case "up": {
          depth += Integer.parseInt(moveInstruction[1]);
          break;
        }
        case "down": {
          depth -= Integer.parseInt(moveInstruction[1]);
          break;
        }
        default:
          System.err.printf("Unknown move command %s%n ಠ╭╮ಠ", moveInstruction[0]);
      }
    }

    return horizontal * Math.abs(depth);
  }

  private int calculateDepthAfterDiveWithAim(String[] input) {
    int horizontal = 0;
    int depth = 0;
    int aim = 0;

    for (String line : input) {
      String[] moveInstruction = line.split(" ");
      switch (moveInstruction[0]) {
        case "forward": {
          horizontal += Integer.parseInt(moveInstruction[1]);
          depth += Integer.parseInt(moveInstruction[1]) * aim;
          break;
        }
        case "up": {
          aim -= Integer.parseInt(moveInstruction[1]);
          break;
        }
        case "down": {
          aim += Integer.parseInt(moveInstruction[1]);
          break;
        }
        default:
          System.err.printf("Unknown move command %s%n", moveInstruction[0]);
      }
    }

    return horizontal * depth;
  }

}
