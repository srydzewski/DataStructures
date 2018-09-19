public class reverseClass {
  CS211Stack<Character> stack;

  public reverseClass() {
    stack = new CS211Stack<Character>();
    stack.init();
  }

  public String reverse(String s) {
    String r = "";
    for (int i = 0; i < s.length(); i++) {
       stack.push(s.charAt(i));
    }
    for (int i = 0; i < stack.size(); i++) {
       r += stack.pop();
    }
    return r;

  }
}
