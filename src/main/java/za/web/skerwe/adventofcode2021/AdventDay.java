package za.web.skerwe.adventofcode2021;

import java.io.IOException;

public interface AdventDay {

  String processPartOne() throws IOException;

  String processPartTwo() throws IOException;

  void setInputFileNamePartOne(String fileName);

  void setInputFileNamePartTwo(String fileName);

}
