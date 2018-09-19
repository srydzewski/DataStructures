import java.util.Scanner;
public class reverseString {
  public static void main(String args[]) {
    rStack rev = new rStack();
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please type a String");
    String s = keyboard.next();
    System.out.println(rev.reverse(s));
  }
}
