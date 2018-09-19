import java.util.Scanner;
public class opStack {
  String output;
  int base;
  CS211Stack<Operator> stack;
  public opStack() {
    output = "";
    base = 0;
    stack = new CS211Stack<Operator>();
    stack.init();
  }

  public String convert (Scanner scan) {
    //boolean go = true;
    while (scan.hasNext()) {
      System.out.println("hi");
      if (scan.hasNextInt()) {
        output += scan.nextInt();
        System.out.println("in int");
      }
      else {
        System.out.println("y0");
        //String help = scan.next();
        //System.out.println("help" + help);
        char s = scan.next().charAt(0);
        //char s = scan.next().charAt(0);
         System.out.println("char" + s);
        if (s == '+' || s == '-') {
          Operator o = new Operator(s, base + 1);
          if ( stack.isEmpty() == false && stack.peek().getPrecedence() >= o.getPrecedence()){
             output += stack.pop().getChar();
             stack.push(o);
          }
          else {
            stack.push(o);
          }
        }
        else if (s == '*' || s == '/') {
          Operator o = new Operator(s, base + 2);
          if ( stack.isEmpty() == false && stack.peek().getPrecedence() >= o.getPrecedence()){
             output += stack.pop().getChar();
             stack.push(o);
          }
          else {
            stack.push(o);
          }
        }
        else if (s == '(') {
          base += 4;
        }
        else if (s == ')') {
          base -= 4;
        }
        else if (s == '=') {
          while (stack.isEmpty() == false) {
             output += stack.pop().getChar();
          }
          //go = false;
        }
         else {

         }
         System.out.println(output + "loop");
      }
    }
    return output;
  }


}
