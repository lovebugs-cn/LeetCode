package leetcode;

import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path){

        Stack<String> stack = new Stack<String>();
        int i = 0;

        while (i < path.length()){

            if (path.charAt(i) == '/'){
                i ++;
                continue;
            }

            String s = "";
            while (i < path.length() && path.charAt(i) != '/'){
                s += path.charAt(i);
                i ++;
            }

            if (s.equals("..") && !stack.empty())
                stack.pop();
            else if (!s.equals("") && !s.equals(".") && !s.equals(".."))
                stack.push(s);
        }

        if (stack.isEmpty())
            return "/";

        String res = "";
        while (!stack.empty())
            res = "/" + stack.pop() + res;

        return res;

    }

    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));
    }
}
