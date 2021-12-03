package za.web.skerwe.adventofcode2021;

import java.io.IOException;

import za.web.skerwe.adventofcode2021.days.Day01;
import za.web.skerwe.adventofcode2021.days.Day02;
import za.web.skerwe.adventofcode2021.days.Day03;

public class Main {

  /**
   * Please have a look at the README.md in the root of this project
   * for instructions on how to call the main method.
   */
  public static void main(String... args) {
    System.out.println("\nAdvent of Code 2021");

    Main main = new Main();

    for (String dayFlag : args) {
      if ("D01".equals(dayFlag)) {
        main.runSpecificDay(new Day01());
      }
      if ("D02".equals(dayFlag)) {
        main.runSpecificDay(new Day02());
      }
      if ("D03".equals(dayFlag)) {
        main.runSpecificDay(new Day03());
      }
    }

    if (args.length == 0) {
      main.runAllAdventOfDays();
    }

    System.out.println("\nThe END (ღ˘⌣˘ღ)\n");
  }

  /**
   * Execute all of the Advent of Code Days!
   */
  public void runAllAdventOfDays() {
    this.runSpecificDay(new Day01());
    this.runSpecificDay(new Day02());
    this.runSpecificDay(new Day03());
  }

  private void runSpecificDay(AdventDay day) {
    System.out.printf("%n%s%n", day.getName());

    try {
      System.out.printf("%d.1 %s: %s%n", day.getId(), day.getPartOneDescription(), day.processPartOne());
      System.out.printf("%d.2 %s: %s%n", day.getId(), day.getPartTwoDescription(), day.processPartTwo());
    } catch (IOException | NumberFormatException exception) {
      exception.printStackTrace();
    }
  }

}
