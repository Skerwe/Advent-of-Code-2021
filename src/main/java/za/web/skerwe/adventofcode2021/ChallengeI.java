package za.web.skerwe.adventofcode2021;

import java.io.IOException;

public interface ChallengeI {

  String processPartOne() throws IOException;

  String processPartTwo() throws IOException;

  void setInputFileName(String fileName);

}
