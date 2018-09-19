import java.util.Scanner;
public class testOP {
  public static void main(String args[]) {
    opStack stack = new opStack();
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Type expression");
    String s = keyboard.nextLine();
    Scanner readS = new Scanner(s);
    System.out.println(stack.convert(readS));
  }
}
