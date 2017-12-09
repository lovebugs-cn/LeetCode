package leetcode;

public class IsPalindrome {
	
	//反转字符串方法,空间复杂度O(n)
	public static boolean isPalindrome2(String s) {
		
		if(s.isEmpty())
			return true;
		
		String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		String env = new StringBuilder(actual).reverse().toString();

		return actual.equals(env);
	}
	
	
	//对撞指针方法
	public static boolean isPalindrome(String s) {
		
		if(s.isEmpty())
			return true;
		
		int i = 0;
		int j = s.length() - 1;
		
		while(i < j) {
			
			if(!isAlphanumeric(s.charAt(i))) {
				i ++;
				continue;
			}
			if(!isAlphanumeric(s.charAt(j))) {
				j --;
				continue;
			}
			if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
				i ++;
				j --;
				continue;
			}
					
			return false;
		}
		
		return true;
	}
	
	public static boolean isAlphanumeric(char c) {
		
		if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		String s3 = ".a";
		System.out.println(isPalindrome(s1));
		System.out.println(isPalindrome2(s2));
		System.out.println(isPalindrome2(s3));
	}

}
