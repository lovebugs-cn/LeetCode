package leetcode;

import java.util.Arrays;

public class RemoveElement {

	public int removeElement(int[] nums, int value){
		int k = 0;
		for(int i = 0; i < nums.length; i ++){
			if(nums[i] != value){
				if(i != k){
					nums[k] = nums[i];
					k ++;
				}
				else
					k ++;
			}
		}
		nums = Arrays.copyOf(nums, k);
		return nums.length;
	}
	
	public static void main(String[] args){
		RemoveElement test = new RemoveElement();
		int[] nums= new int[]{3,2,2,3,2};
		int result = test.removeElement(nums, 3);
		System.out.println(result);
	}
}
