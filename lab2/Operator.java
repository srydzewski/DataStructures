public class Operator {
  private char c;
  private int precedence;

  public Operator(char math, int i) {
    c = math;
    precedence = i;
  }

  public char getChar() {
    return c;
  }

  public int getPrecedence() {
    return precedence;
  }


}
