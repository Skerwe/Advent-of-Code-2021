package za.web.skerwe.adventofcode2021;

import za.web.skerwe.adventofcode2021.days.Day01;

public class Main {

  public static void main(String... args) {
    System.out.println("\nAdvent of Code 2021\n");

    Main main = new Main();

    for (String dayFlag : args) {
      if ("D01".equals(dayFlag)) {
        main.runDay01();
      }
    }

    if (args.length == 0) {
      main.runAllAdventOfDays();
    }

    System.out.println("\nThe END (ღ˘⌣˘ღ)\n");
  }

  public void runAllAdventOfDays() {
    this.runDay01();
  }

  public void runDay01() {
    AdventDay day01 = new Day01();
    System.out.println("Day 1: Sonar Sweep\n");
    System.out.printf("1.1 The number of times a depth measurement increases: %s%n", day01.processPartOne());
    System.out.printf("1.2 The number of times the sum of measurements in the sliding window increases: %s%n",
        day01.processPartTwo());
  }

}
