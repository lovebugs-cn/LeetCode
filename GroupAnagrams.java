import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs){

        Map<String,List<String>> map = new HashMap<String, List<String>>();

        for (String s : strs){
            char[] sc = s.toCharArray();
            Arrays.sort(sc);
            String strKey = String.valueOf(sc);
            if(!map.containsKey(strKey))
                map.put(strKey,new ArrayList<String>());

            map.get(strKey).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
