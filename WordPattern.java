package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPattern {

    public static boolean wordPattern(String pattern,String str){

        char[] patterns = pattern.toCharArray();
        String[] strs = str.split(" ");
        Map<Character,String> map = new HashMap<Character, String>();
        List<String> list = new ArrayList<String>();

        if(patterns.length != strs.length)
            return false;

        int i = 0,j = 0;

        while(i < patterns.length && j < strs.length){

            if(!map.containsKey(patterns[i])){
                if(!list.contains(strs[j])){
                    map.put(patterns[i],strs[j]);
                    list.add(strs[j]);
                    i ++;
                    j ++;
                }
                else
                    return false;
            }
            else{
                if(!strs[j].equals(map.get(patterns[i])))
                    return false;
                else{
                    i ++;
                    j ++;
                }
            }

        }

        return true;

    }

    public static void main(String[] args) {
        String pattern1 = "abba";
        String str1 = "dog cat cat dog";
        String str2 = "dog cat cat fish";
        String str3 = "dog dog dog dog";
        System.out.println(wordPattern(pattern1,str1));
        System.out.println(wordPattern(pattern1,str2));
        System.out.println(wordPattern(pattern1,str3));
    }
}
