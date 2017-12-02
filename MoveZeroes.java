package leetcode;

import java.util.Arrays;

public class MoveZeroes {

	public void moveZeroes(int[] nums){
		int k = 0;
		for(int i = 0; i < nums.length; i ++){
			if(nums[i] != 0){
				if(i != k){
					swap(nums,i,k);
					k ++;
				}
				else
					k ++;
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{0, 1, 0, 3, 12};
		MoveZeroes test = new MoveZeroes();
		test.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
	
}
