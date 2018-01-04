package leetcode;

import java.util.Stack;

public class IsValid {

    public static boolean isValid(String s){

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if (stack.isEmpty())
                    return false;
                else{
                    char c1 = stack.pop();
                    char match;
                    if (c == ')')
                        match = '(';
                    else if (c == ']')
                        match = '[';
                    else
                        match = '{';

                    if (c1 != match)
                        return false;
                }
            }
        }

        if (!stack.isEmpty())
            return false;

        return true;
    }

    public static boolean isValid2(String s){
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()){
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([{}])";
        System.out.println(isValid2(s));
    }
}
