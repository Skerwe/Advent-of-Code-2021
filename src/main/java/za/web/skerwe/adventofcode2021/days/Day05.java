package za.web.skerwe.adventofcode2021.days;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import java.io.IOException;
import java.util.ArrayList;

import za.web.skerwe.adventofcode2021.AdventDay;
import za.web.skerwe.adventofcode2021.util.InputFileReader;

public class Day05 extends AdventDay {

  /**
   * Setup for the day's challenge (¬‿¬).
   */
  public Day05() {
    id = 5;
    name = "Hydrothermal Venture";
    partOneDescription = "At how many points do at least two lines overlap? (horizontal and vertical lines)";
    partTwoDescription = "At how many points do at least two lines overlap? (diagonal lines)";

    inputPart1 = "src/main/resources/input05-p1.txt";
  }

  @Override
  public String processPartOne() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);

    ArrayList<Line2D> graphData = new ArrayList<>();
    Point2D gridSize = buildGraphData(graphData, input);

    int[][] grid = new int[(int) gridSize.getX()][(int) gridSize.getY()];
    plotGraphOnGridHorizontalAndVertical(grid, graphData);

    // printgrid(grid);

    return String.valueOf(calculateOverlapPoints(grid));
  }

  @Override
  public String processPartTwo() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);

    ArrayList<Line2D> graphData = new ArrayList<>();
    Point2D gridSize = buildGraphData(graphData, input);

    int[][] grid = new int[(int) gridSize.getX()][(int) gridSize.getY()];
    for (Line2D lineData : graphData) {
      plotLine(grid, lineData);
    }

    // printgrid(grid);

    return String.valueOf(calculateOverlapPoints(grid));
  }

  private Point2D buildGraphData(ArrayList<Line2D> graphData, String[] input) {
    float gridX = 0;
    float gridY = 0;

    String[] parts = null;
    String[] point1 = null;
    String[] point2 = null;

    float x1 = 0;
    float y1 = 0;
    float x2 = 0;
    float y2 = 0;

    for (String line : input) {
      parts = line.split(" ");

      point1 = parts[0].split(",");
      point2 = parts[2].split(",");

      x1 = Float.parseFloat(point1[0]);
      y1 = Float.parseFloat(point1[1]);
      x2 = Float.parseFloat(point2[0]);
      y2 = Float.parseFloat(point2[1]);

      if (x1 > gridX) {
        gridX = x1;
      }
      if (x2 > gridX) {
        gridX = x2;
      }
      if (y1 > gridY) {
        gridY = y1;
      }
      if (y2 > gridY) {
        gridY = y2;
      }

      graphData.add(
          new Line2D.Float(
              new Point2D.Float(Float.parseFloat(point1[0]), Float.parseFloat(point1[1])),
              new Point2D.Float(Float.parseFloat(point2[0]), Float.parseFloat(point2[1]))));
    }

    return new Point2D.Float(gridX + 1, gridY + 1);
  }

  private void plotGraphOnGridHorizontalAndVertical(int[][] grid, ArrayList<Line2D> graphData) {
    for (Line2D lineData : graphData) {
      if (lineData.getX1() == lineData.getX2() || lineData.getY1() == lineData.getY2()) {
        plotLine(grid, lineData);
      }
    }
  }

  private void plotLine(int[][] grid, Line2D lineData) {
    int x1 = (int) lineData.getP1().getX();
    int y1 = (int) lineData.getP1().getY();
    int x2 = (int) lineData.getP2().getX();
    int y2 = (int) lineData.getP2().getY();

    for (int x = 0; x < lineData.getP1().distance(lineData.getP2()); x++) {
      grid[y1][x1] += 1;

      if (x1 != x2 && x1 > x2) {
        x1--;
      } else if (x1 != x2) {
        x1++;
      }

      if (y1 != y2 && y1 > y2) {
        y1--;
      } else if (y1 != y2) {
        y1++;
      }

      if (x1 == x2 && y1 == y2) {
        // diagonal lines distance is longer!
        break;
      }

    }
    grid[y2][x2] += 1; // Plot point 2
  }

  private int calculateOverlapPoints(int[][] grid) {
    int overlap = 0;
    for (int x = 0; x < grid.length; x++) {
      for (int y = 0; y < grid[x].length; y++) {
        if (grid[x][y] > 1) {
          overlap = overlap + 1;
        }
      }
    }
    return overlap;
  }

  private void printgrid(int[][] grid) {
    System.out.println();
    for (int x = 0; x < grid.length; x++) {
      for (int y = 0; y < grid[x].length; y++) {
        System.out.print(grid[x][y] + "|");
      }
      System.out.println();
    }
  }
}
