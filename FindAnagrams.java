package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
	
	public static List<Integer> findAnagrams(String s,String p){
		
		List<Integer> list = new ArrayList<Integer>();
		
		if(s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;
		
		int l = 0;
		int r = 0;
		int count = p.length();
		int[] hash = new int[256];
		
		for(char c : p.toCharArray())
			hash[c] ++;
		
		while(r < s.length()) {
			
			if(hash[s.charAt(r++)]-- >= 1)
				count --;
			
			if(count == 0)
				list.add(l);
			
			if(r - l == p.length() && hash[s.charAt(l++)]++ >= 0)
				count ++;
			
		}
		
		return list;
		
	}
	
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println(findAnagrams(s,p));
	}

}
