package leetcode;

import java.util.Arrays;

public class Merge {
	
	public static void merge(int[] nums1,int m,int[] nums2,int n){
		
		int index1 = m - 1;
		int index2 = n - 1;
		int len = m + n - 1;
		
		while(index1 >= 0 && index2 >= 0){
			if(nums1[index1] > nums2[index2]){
				nums1[len] = nums1[index1];
				len --;
				index1 --;
			}
			else{
				nums1[len] = nums2[index2];
				len --;
				index2 --;
			}
		}
		while(index2 >= 0){
			nums1[len] = nums2[index2];
			len --;
			index2 --;
		}
		
	}
	
	public static void main(String[] args){
		
		int[] nums1 = new int[10];
		nums1[0] = 1;
		nums1[1] = 2;
		nums1[2] = 3;
		nums1[3] = 6;
		nums1[4] = 8;
		int[] nums2 = {0,2,5,9,10};
		int m = 5;
		int n = 5;
		
		merge(nums1,m,nums2,n);
		
		System.out.println(Arrays.toString(nums1));
		
		
	}
	
	

}
