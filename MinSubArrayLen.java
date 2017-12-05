package leetcode;

public class MinSubArrayLen {
	
	public static int minSubArrayLen(int s,int[] nums) {
		
		if(s < 0 || nums == null)
			throw new IllegalArgumentException("Illigal Argument");
		
		int l = 0;
		int r = -1;
		int sum = 0;
		int len = nums.length + 1;
		
		while(l < nums.length) {
			
			if(r + 1 < nums.length && sum < s) {
				r ++;
				sum += nums[r];
			}else {
				sum -= nums[l];
				l ++;
			}
			
			if(sum >= s)
				len = Math.min(len, r - l + 1);
		}
		
		//没找到的情况，结果为0
		if(len == nums.length + 1)
			return 0;
			
		return len;
	}
	
	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5};
		int s = 15;
		int res = minSubArrayLen(s,nums);
		System.out.println(res);
		
	}

}
