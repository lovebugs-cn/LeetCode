package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsIsomorphic {

    public static boolean isIsomorphic(String s,String t){

        if(s.length() != t.length())
            return false;

        Map<Character,Character> map = new HashMap<Character, Character>();
        List<Character> list = new ArrayList<Character>();

        int i = 0,j = 0;
        while(i < s.length() && j < t.length()){
            if(!map.containsKey(s.charAt(i))){
                if(!list.contains(t.charAt(j))){
                    list.add(t.charAt(j));
                    map.put(s.charAt(i),t.charAt(j));
                    i ++;
                    j ++;
                }
                else
                    return false;

            }
            else{
                if(!map.get(s.charAt(i)).equals(t.charAt(j)))
                    return false;
                else
                    i ++;
                    j ++;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String s1 = "egg";
        String t1 = "aaa";
        String s2 = "foo";
        String t2 = "bar";
        System.out.println(isIsomorphic(s1,t1));
        System.out.println(isIsomorphic(s2,t2));
    }
}
