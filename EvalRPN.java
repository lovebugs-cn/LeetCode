package leetcode;

import java.util.Stack;

public class EvalRPN {

    public static int evalRPN(String[] tokens){

        Stack<Integer> stack = new Stack<Integer>();
        for (String s : tokens){
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                int n = Integer.valueOf(s);
                stack.push(n);
            } else {
              int x1 = stack.pop();
              int x2 = stack.pop();
              if (s.equals("+"))
                  stack.push(x2 + x1);
              else if (s.equals("-"))
                  stack.push(x2 - x1);
              else if (s.equals("*"))
                  stack.push(x2 * x1);
              else
                  stack.push((x2 / x1));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }
}
