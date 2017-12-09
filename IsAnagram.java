package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public static boolean isAnagram(String s,String t){

        if(s.length() != t.length())
            return false;

        Map<Character,Integer> map = new HashMap<Character,Integer>();

        char[] cs = s.toCharArray();
        for(char c : cs){
            if(!map.containsKey(c))
                map.put(c,1);
            else
                map.put(c,map.get(c) + 1);
        }

        char[] ts = t.toCharArray();
        for(char c : ts){
            if(!map.containsKey(c))
                return false;
            else{
                if(map.get(c) < 1)
                    return  false;
                else
                    map.put(c,map.get(c) - 1);
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s1,t1));
        System.out.println(isAnagram(s2,t2));
    }
}
