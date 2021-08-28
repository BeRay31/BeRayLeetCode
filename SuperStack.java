import java.util.ArrayList;

public class SuperStack {
  static void superStack(String[] operations) {
    ArrayList<Integer> stack = new ArrayList<>(); // ArrayList as a stack
    for(String s : operations) {
      if(s.equals("pop")) {
        pop(stack);
      } else if (s.substring(0, 3).equals("inc")) {
        String params = s.substring(3);
        // get rid leading spaces
        params = params.trim();
        // split with spaces
        String[] paramsArr = params.split(" "); // [0] => i, [1] => v
        int i = Integer.parseInt(paramsArr[0]);
        int v = Integer.parseInt(paramsArr[1]);
        inc(stack, i, v);
      } else if(s.substring(0, 4).equals("push")) {
        String params = s.substring(4);
        // get rid leading spaces
        params = params.trim();
        // convert params to long and execute function
        push(stack, Integer.parseInt(params));
      }
      int stackSize = stack.size();
      if(stackSize > 0) {
        System.out.println(stack.get(stackSize-1));
      } else {
        System.out.println("EMPTY");
      }
    }
  }
  public static void pop(ArrayList<Integer> stack) {
    stack.remove(stack.size() - 1);
  }

  public static void push(ArrayList<Integer> stack, int num) {
    stack.add(num);
  }

  public static void inc(ArrayList<Integer> stack, int i, int v) {
    for(int index = 0; index < i; index++) {
      stack.set(index, stack.get(index) + v);
    }
  }

  public static void main(String[] args) {
    SuperStack.superStack(new String[]{"push 4", "pop", "push 3", "push 5", "push 2", "inc 3 1", "pop", "push 1", "inc 2 2", "push 4", "pop", "pop"});
  }
}
