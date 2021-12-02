package za.web.skerwe.adventofcode2021;

import java.io.IOException;

import za.web.skerwe.adventofcode2021.days.Day01;
import za.web.skerwe.adventofcode2021.days.Day02;

public class Main {

  /**
   * Main class to start the application.
   *
   * Please have a look at the README.md in the root of this project
   * for instructions on how to call the main method.
   */
  public static void main(String... args) {
    System.out.println("\nAdvent of Code 2021");

    Main main = new Main();

    for (String dayFlag : args) {
      if ("D01".equals(dayFlag)) {
        main.runDay01();
      }
      if ("D02".equals(dayFlag)) {
        main.runDay02();
      }
    }

    if (args.length == 0) {
      main.runAllAdventOfDays();
    }

    System.out.println("\nThe END (ღ˘⌣˘ღ)\n");
  }

  /**
   * Execute all of the Advent of Code Days.
   */
  public void runAllAdventOfDays() {
    this.runDay01();
    this.runDay02();
  }

  /**
   * Execute Advent of Code Day 1 code.
   */
  public void runDay01() {
    AdventDay day = new Day01();
    System.out.println("\nDay 1: Sonar Sweep\n");

    try {
      System.out.printf("1.1 The number of times a depth measurement increases: %s%n", day.processPartOne());
      System.out.printf("1.2 The number of times the sum of measurements in the sliding window increases: %s%n",
          day.processPartTwo());
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  /**
   * Execute Advent of Code Day 2 code.
   */
  public void runDay02() {
    AdventDay day = new Day02();
    System.out.println("\nDay 2: Dive!\n");

    try {
      System.out.printf("2.1 Multiplying final horizontal position by the final depth: %s%n", day.processPartOne());
      System.out.printf("2.2 Multiplying final horizontal position by the final depth: %s%n", day.processPartTwo());
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

}
