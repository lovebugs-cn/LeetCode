package leetcode;

public class MinWindow {
	
	public static String minWindow(String s,String t) {
		
		int[] s_freq = new int[128];
		int[] t_freq = new int[128];
		
		for(char c: t.toCharArray()) {
			t_freq[c] ++;
		}
		
		int l = 0;
		int r = 0;
		int minLen = s.length() + 1;
		int count = 0;
		String minWin = "";
		
		while(r < s.length()) {
			
			if(t_freq[s.charAt(r)] > 0) {
				if(s_freq[s.charAt(r)] < t_freq[s.charAt(r)])
					count ++;
				
				s_freq[s.charAt(r)] ++;
			}
			
			if(count == t.length()) {
				while(t_freq[s.charAt(l)] == 0 || s_freq[s.charAt(l)] > t_freq[s.charAt(l)]) {
					
					if(s_freq[s.charAt(l)] > t_freq[s.charAt(l)])
						s_freq[s.charAt(l)] --;
					
					l ++;
				}
				if(r-l+1 < minLen) {
					minLen = r-l+1;
					minWin = s.substring(l,r+1);
				}
					
			}
			
			r ++;
			
		}
		
		return minWin;
	}
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s,t));
	}

}
