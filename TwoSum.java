package leetcode;

import java.util.Arrays;

public class TwoSum {
	
	//利用二分查找的方法
	public static int[] twoSum(int[] nums,int target) {
		int[] res = new int[2];
		for(int i = 0; i < nums.length - 1; i ++) {
			int l = i + 1;
			int r = nums.length - 1;
			if(binarySearch(nums,l,r,target-nums[i]) != -1) {
				res[0] = i + 1;//题目中说索引从1开始
				res[1] = binarySearch(nums,l,r,target-nums[i]) + 1;
				return res;
			}
		}
		
		return res;
	}
	
	//利用对撞指针的方法
	public static int[] twoSum2(int[] nums,int target) {
		
		int[] res = new int[2];
		
		int i = 0;
		int j = nums.length - 1;
		while(i < j) {
			
			if(nums[i] + nums[j] == target) {
				res[0] = i + 1;
				res[1] = j + 1;
				return res;
			}
			else if(nums[i] + nums[j] > target)
				j --;
			else
				i ++;
			
		}
			
		return res;
	}
	
	public  static int binarySearch(int[] nums,int l,int r,int target) {
		
		int mid = (r-l)/2 + l;
		
		while(l <= r) {
			if(nums[mid] == target)
				return mid;
			else if(nums[mid] > target) {
				r = mid - 1;
				return binarySearch(nums,l,r,target);
			}
				
			else {
				l = mid + 1;
				return binarySearch(nums,l,r,target);
			}
				
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] res = twoSum(nums,target);
		System.out.println(Arrays.toString(res));
		
		int[] res2 = twoSum2(nums,target);
		System.out.println(Arrays.toString(res2));
	}

}
