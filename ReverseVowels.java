package leetcode;

import java.util.Arrays;

public class ReverseVowels {
	
	public static String reverseVowels(String s) {
		
		char[] arr = s.toCharArray();
		int i = 0;
		int j = arr.length - 1;
		
		while(i < j) {
			if(!isVowel(arr[i])) {
				i ++;
				continue;
			}
			if(!isVowel(arr[j])) {
				j --;
				continue;
			}
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
	
	public static boolean isVowel(char c) {
		char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
		for(char vowel : vowels) {
			if(vowel == c)
				return true;
		}
		
		return false;
	}
	

	public static void main(String[] args) {
		String s = "leetcode";
		System.out.println(reverseVowels(s));
		System.out.println(isVowel('a'));
	}
}
