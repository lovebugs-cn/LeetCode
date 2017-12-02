package leetcode;

public class ReverseString {
	
	public static String reverseString(String s) {
		
		String newstr = new StringBuilder(s).reverse().toString();
		
		return newstr;
		
	}
	
	public static String reverseString2(String s) {
		
		char[] arr = s.toCharArray();
		
		int i = 0;
		int j = arr.length - 1;
		
		while(i < j) {
			swap(arr,i,j);
			i ++;
			j --;
		}
		
		return String.copyValueOf(arr);
	}
	
	public static void swap(char[] arr,int i,int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		String s = "hello";
		System.out.println(reverseString(s));
		System.out.println(reverseString2(s));
	}

}
