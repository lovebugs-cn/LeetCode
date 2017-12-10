package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {

    public static String frequencySort(String s){

        Map<Character,Integer> map = new HashMap<Character, Integer>();

        for(char c : s.toCharArray()){
            if(!map.containsKey(c))
                map.put(c,1);
            else
                map.put(c,map.get(c) + 1);
        }

        List<Character>[] bucket = new List[s.length()+1];//频率是从1开始的，而索引从0开始，所以开辟的数组长度要加1

        for(Character charKey : map.keySet()){
            int freq = map.get(charKey);
            if(bucket[freq] == null)
                bucket[freq] = new ArrayList<Character>();

            bucket[freq].add(charKey);
        }

        StringBuilder res = new StringBuilder();
        for(int i = bucket.length - 1; i >= 0; i --){
            if(bucket[i] != null){
                for(char c : bucket[i])
                    for(int j = 0; j < map.get(c); j ++)
                        res.append(c);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "eeeee";
        System.out.println(frequencySort(s));
    }
}
