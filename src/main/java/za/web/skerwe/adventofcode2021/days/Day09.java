package za.web.skerwe.adventofcode2021.days;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import za.web.skerwe.adventofcode2021.AdventDay;
import za.web.skerwe.adventofcode2021.util.InputFileReader;

public class Day09 extends AdventDay {

  /**
   * Setup for the day's challenge (¬‿¬).
   */
  public Day09() {
    id = 9;
    name = "Smoke Basin";
    partOneDescription = "What is the sum of the risk levels of all low points on your heightmap?";
    partTwoDescription = "What do you get if you multiply together the sizes of the three largest basins?";

    inputPart1 = "src/main/resources/input09-p1.txt";
  }

  @Override
  public String processPartOne() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);
    int total = calculateLowPointRiskLevel(buildHeightMap(input));
    return String.valueOf(total);
  }

  @Override
  public String processPartTwo() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);

    int total = findBigestBasins(buildHeightMap(input));
    return String.valueOf(total);
  }

  private int[][] buildHeightMap(String[] input) {
    int[][] heightMap = new int[input.length][input[0].length()];

    for (int row = 0; row < input.length; row++) {
      for (int column = 0; column < input[row].length(); column++) {
        heightMap[row][column] = Integer.parseInt(input[row].charAt(column) + "");
      }
    }

    return heightMap;
  }

  private int calculateLowPointRiskLevel(int[][] heightMap) {
    int riskLevel = 0;

    boolean lowestInRow = false;
    boolean lowestInColumn = false;
    for (int row = 0; row < heightMap.length; row++) {
      for (int column = 0; column < heightMap[row].length; column++) {

        if (column == 0) {
          lowestInRow = heightMap[row][column] < heightMap[row][column + 1];
        } else if (column == (heightMap[row].length - 1)) {
          lowestInRow = heightMap[row][column] < heightMap[row][column - 1];
        } else {
          lowestInRow = heightMap[row][column] < heightMap[row][column - 1]
              && heightMap[row][column] < heightMap[row][column + 1];
        }

        if (row == 0) {
          lowestInColumn = heightMap[row][column] < heightMap[row + 1][column];
        } else if (row == (heightMap.length - 1)) {
          lowestInColumn = heightMap[row][column] < heightMap[row - 1][column];
        } else {
          lowestInColumn = heightMap[row][column] < heightMap[row - 1][column]
              && heightMap[row][column] < heightMap[row + 1][column];
        }

        if (lowestInRow && lowestInColumn) {
          riskLevel += heightMap[row][column] + 1;
        }

        lowestInRow = false;
        lowestInColumn = false;
      }
    }

    return riskLevel;
  }

  private int findBigestBasins(int[][] heightMap) {
    ArrayList<Integer> basins = new ArrayList<>();

    int total = 0;
    for (int row = 0; row < heightMap.length; row++) {
      for (int column = 0; column < heightMap[row].length; column++) {

        if (heightMap[row][column] < 9) {
          total = calcBasinSizeRow(heightMap, row, column);
          // System.out.println("total=" + total);
          basins.add(total);
        }
      }
    }

    Collections.sort(basins);
    Collections.sort(basins, Collections.reverseOrder());

    return basins.get(0) * basins.get(1) * basins.get(2);
  }

  private int calcBasinSizeRow(int[][] heightMap, int rowIndex, int colIndex) {
    if (rowIndex == heightMap.length || colIndex == heightMap[rowIndex].length || heightMap[rowIndex][colIndex] == 9) {
      return 0;
    }

    int count = 0;
    if ((colIndex + 1 < heightMap[rowIndex].length) && (heightMap[rowIndex][colIndex + 1] < 9)) { // right

      count = calcBasinSizeRow(heightMap, rowIndex, colIndex + 1);
      count += calcBasinSizeColum(heightMap, rowIndex + 1, colIndex);
      heightMap[rowIndex][colIndex] = 9;
      return count + 1;
    } else if ((rowIndex + 1 < heightMap.length) && (heightMap[rowIndex + 1][colIndex] < 9)) { // down
      count = calcBasinSizeColum(heightMap, rowIndex + 1, colIndex);
      heightMap[rowIndex][colIndex] = 9;
      return count + 1;
    } else {
      heightMap[rowIndex][colIndex] = 9;
      return count + 1;
    }
  }

  private int calcBasinSizeColum(int[][] heightMap, int rowIndex, int colIndex) {
    if (rowIndex == heightMap.length || colIndex == heightMap[rowIndex].length || heightMap[rowIndex][colIndex] == 9) {
      return 0;
    }

    int count = 0;
    if ((colIndex + 1 < heightMap[rowIndex].length) && (heightMap[rowIndex][colIndex + 1] < 9)) { // right
      count = calcBasinSizeRow(heightMap, rowIndex, colIndex + 1);
      count += calcBasinSizeColum(heightMap, rowIndex + 1, colIndex);
      count += checkLeft(heightMap, rowIndex, colIndex - 1);
      heightMap[rowIndex][colIndex] = 9;
      return count + 1;
    } else if ((rowIndex + 1 < heightMap.length) && heightMap[rowIndex + 1][colIndex] < 9) { // down
      count = calcBasinSizeColum(heightMap, rowIndex + 1, colIndex);
      count += checkLeft(heightMap, rowIndex, colIndex - 1);
      heightMap[rowIndex][colIndex] = 9;
      return count + 1;
    } else {
      count += checkLeft(heightMap, rowIndex, colIndex - 1);
      heightMap[rowIndex][colIndex] = 9;
      return count + 1;
    }
  }

  private int checkLeft(int[][] heightMap, int rowIndex, int colIndex) {
    if (colIndex == -1 || heightMap[rowIndex][colIndex] == 9) {
      return 0;
    }

    int count = 0;
    if ((rowIndex + 1 < heightMap.length) && heightMap[rowIndex + 1][colIndex] < 9) { // down
      count = checkDown(heightMap, rowIndex + 1, colIndex);
      count += checkLeft(heightMap, rowIndex, colIndex - 1);
      heightMap[rowIndex][colIndex] = 9;
      return count + 1;
    } else if ((colIndex - 1 >= 0) && heightMap[rowIndex][colIndex - 1] < 9) { // left
      count = checkLeft(heightMap, rowIndex, colIndex - 1);
      heightMap[rowIndex][colIndex] = 9;
      return count + 1;
    } else {
      heightMap[rowIndex][colIndex] = 9;
      return 1;
    }

  }

  private int checkDown(int[][] heightMap, int rowIndex, int colIndex) {
    if (rowIndex == heightMap.length || heightMap[rowIndex][colIndex] == 9) {
      return 0;
    }

    int count = 0;
    if ((rowIndex + 1 < heightMap.length) && heightMap[rowIndex + 1][colIndex] < 9) {
      count = checkDown(heightMap, rowIndex + 1, colIndex);
      count += checkLeft(heightMap, rowIndex, colIndex - 1);
      heightMap[rowIndex][colIndex] = 9;
      return count + 1;
    } else {
      count = checkLeft(heightMap, rowIndex, colIndex - 1);
      heightMap[rowIndex][colIndex] = 9;
      return count + 1;
    }

  }

}
