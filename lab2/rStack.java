public class rStack {
  CS211Stack<Character> stack;

  public rStack() {
    stack = new CS211Stack<Character>();
    stack.init();
  }

  public String reverse(String s) {
    String r = "";
    for (int i = 0; i < s.length(); i++) {
       stack.push(s.charAt(i));
    }
    while (!(stack.isEmpty())) {
      r += stack.pop();
    }
    return r;

  }
}
