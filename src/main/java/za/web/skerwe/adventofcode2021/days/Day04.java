package za.web.skerwe.adventofcode2021.days;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import za.web.skerwe.adventofcode2021.AdventDay;
import za.web.skerwe.adventofcode2021.util.InputFileReader;

public class Day04 extends AdventDay {

  /**
   * Setup for the day's challenge (¬‿¬).
   */
  public Day04() {
    id = 4;
    name = "Day 4: Giant Squid";
    partOneDescription = "Final score for choosen board";
    partTwoDescription = "Final score for board who will win last";

    inputPart1 = "src/main/resources/input04-p1.txt";
  }

  @Override
  public String processPartOne() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);

    String[] bingoNumbers = input[0].split(",");
    ArrayList<int[][][]> bingoBoards = new ArrayList<>();
    createBingoBoardAndData(input, bingoBoards);

    int[][][] winningBoard = new int[5][5][2];
    int winningNumber = 0;

    play: for (String bingoNumber : bingoNumbers) {
      for (int[][][] board : bingoBoards) {
        // Check value found and mark value true (1)
        fullBingoNumberIn(board, Integer.parseInt(bingoNumber));
        // Check if a row or column is complete
        if (checkBingoBoardComplete(board)) {
          winningBoard = board;
          winningNumber = Integer.parseInt(bingoNumber);
          break play;
        }
      }
      // TODO: use flag to break outer loop ?
    }

    int finalScore = calculateScore(winningBoard) * winningNumber;
    return String.valueOf(finalScore);
  }

  @Override
  public String processPartTwo() throws IOException {
    String[] input = InputFileReader.readInputFile(this.inputPart1);

    String[] bingoNumbers = input[0].split(",");
    ArrayList<int[][][]> bingoBoards = new ArrayList<>();
    createBingoBoardAndData(input, bingoBoards);

    int[][][] winningBoard = new int[5][5][2];
    int winningNumber = 0;

    int boardIndex = 0;
    ArrayList<Integer> winningIndex = new ArrayList<>();

    for (String bingoNumber : bingoNumbers) {
      for (int[][][] board : bingoBoards) {
        fullBingoNumberIn(board, Integer.parseInt(bingoNumber));
      }

      boardIndex = 0;
      for (int[][][] board : bingoBoards) {
        if (checkBingoBoardComplete(board)) {
          // winningBoard = board;
          winningNumber = Integer.parseInt(bingoNumber);
          winningIndex.add(boardIndex);
          // break;
        }
        boardIndex++;
      }

      Collections.sort(winningIndex, Collections.reverseOrder());
      for (int index : winningIndex) {
        winningBoard = bingoBoards.remove(index);
      }
      winningIndex = new ArrayList<>();
    }

    int finalScore = calculateScore(winningBoard) * winningNumber;
    return String.valueOf(finalScore);
  }

  private void createBingoBoardAndData(String[] input, ArrayList<int[][][]> bingoBoards) {
    int[][][] bingoBoard = new int[5][5][2];

    int boardIndex = 0; // index for the row

    for (int index = 1; index < input.length; index++) {
      if (input[index].equals("")) {
        bingoBoard = new int[5][5][2];
        bingoBoards.add(bingoBoard);
        boardIndex = 0;
      } else {
        int columnIndex = 0;
        for (String value : input[index].split(" ")) {
          if (!value.equals("")) {
            bingoBoard[boardIndex][columnIndex][0] = Integer.parseInt(value);
            bingoBoard[boardIndex][columnIndex][1] = 0;
            columnIndex = columnIndex + 1;
          }
        }
        boardIndex = boardIndex + 1;
      }
    }
  }

  private void fullBingoNumberIn(int[][][] bingoBoard, int number) {
    for (int indexRow = 0; indexRow < 5; indexRow++) {
      for (int indexColumn = 0; indexColumn < 5; indexColumn++) {
        if (bingoBoard[indexRow][indexColumn][0] == number) {
          bingoBoard[indexRow][indexColumn][1] = 1;
        }
      }
    }
  }

  private boolean checkBingoBoardComplete(int[][][] bingoBoard) {
    int countRow = 0;
    for (int indexRow = 0; indexRow < 5; indexRow++) {
      for (int indexColumn = 0; indexColumn < 5; indexColumn++) {
        if (bingoBoard[indexRow][indexColumn][1] == 1) {
          countRow = countRow + 1;
        }
      }
      if (countRow == 5) {
        return true;
      } else {
        countRow = 0;
      }
    }

    int countColumn = 0;
    for (int indexColumn = 0; indexColumn < 5; indexColumn++) {
      for (int indexRow = 0; indexRow < 5; indexRow++) {
        if (bingoBoard[indexRow][indexColumn][1] == 1) {
          countColumn = countColumn + 1;
        }
      }
      if (countColumn == 5) {
        return true;
      } else {
        countColumn = 0;
      }
    }

    return false;
  }

  private int calculateScore(int[][][] bingoBoard) {
    int score = 0;
    for (int indexRow = 0; indexRow < 5; indexRow++) {
      for (int indexColumn = 0; indexColumn < 5; indexColumn++) {
        if (bingoBoard[indexRow][indexColumn][1] == 0) {
          score = score + bingoBoard[indexRow][indexColumn][0];
        }
      }
    }
    return score;
  }

}
