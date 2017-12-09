package leetcode;

public class LengthOfLongestSubstring {
	
	public static int lengthOfLongestSubstring(String s) {
		
		int l = 0;
		int r = -1;
		int len = 0;
		int[] freq = new int[256];
		
		while(l < s.length()) {
			
			if(r + 1 < s.length() && freq[s.charAt(r+1)] == 0) {
				r ++;
				freq[s.charAt(r)] ++;
			}else {
				freq[s.charAt(l)] --;
				l ++;
			}
			
			len = Math.max(len, r-l+1);
			
			}	
		
		return len;
	}
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
		int i = 1;
		if(i++>2)
			System.out.println(i);
		System.out.println(i);
	}

}
