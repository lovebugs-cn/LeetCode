package leetcode;

import java.util.Arrays;

public class RemoveDuplicates {

	public int removeDuplicates(int[] nums){
		
		int k = 1;//注意这里索引要从１开始，因为第一个数肯定不重复
		for(int i = 1; i < nums.length; i ++){
			if(nums[i] != nums[i - 1]){
				if(i != k){
					nums[k] = nums[i];
					k ++;
				}
				else{
					k ++;
				}
			}
		}
		
		nums = Arrays.copyOf(nums, k);
		
		return k;
	}

//the duplicates are allowed at most twice
public int removeDuplicates２(int[] nums){
		
		int k = 1;
		int count = 0;
		for(int i = 1; i < nums.length; i ++){
			if(nums[i] != nums[i - 1]){
				count = 0;
				nums[k] = nums[i];
				k ++;
			}else{
				count ++;
				if(count >= 2)
					continue;
				
				nums[k] = nums[i];
				k ++;
			}
		}
		
		nums = Arrays.copyOf(nums, k);
		
		return k;
	}
	
	public static void main(String[] args){
		RemoveDuplicates test = new RemoveDuplicates();
		int[] nums = new int[]{1,1,2};
		int result = test.removeDuplicates(nums);
		System.out.println(result);
		
		RemoveDuplicates test2 = new RemoveDuplicates();
		int[] nums2 = new int[]{1,1,1,2,2,3};
		int result2 = test2.removeDuplicates２(nums2);
		System.out.println(result2);
	}
	
}
