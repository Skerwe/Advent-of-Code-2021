package za.web.skerwe.adventofcode2021;

public abstract class AdventDay implements ChallengeI {

  protected int id;
  protected String name;
  protected String partOneDescription;
  protected String partTwoDescription;

  protected String inputPart1;

  @Override
  public void setInputFileName(String fileName) {
    this.inputPart1 = fileName;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPartOneDescription() {
    return partOneDescription;
  }

  public String getPartTwoDescription() {
    return partTwoDescription;
  }
}
