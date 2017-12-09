package leetcode;

public class FindKthLargest {
	
	public static int findKthLargest(int[] nums,int k) {
		
		return findKthLargest(nums,0,nums.length-1,k - 1);//索引是从0开始的
		
	}
	
	public static int findKthLargest(int[] nums,int l,int r,int k) {
		
		if(l == r)
			return nums[l];
		
		int p = partition(nums,l,r);
		
		if(p == k)
			return nums[p];
		else if(k > p)
			return findKthLargest(nums,p + 1,r,k);
		else
			return findKthLargest(nums,l,p - 1,k);
		
	}
	
	public static int partition(int[] nums,int l,int r) {
		
		swap(nums,l,(int)(Math.random()*(r-l+1)+l));
		int v = nums[l];
		int j = l;
		for(int i = l + 1; i <= r; i ++) {
			if(nums[i] > v) {
				swap(nums,i,j + 1);
				j ++;
			}
		}
		
		swap(nums,l,j);
		
		return j;
		
	}
	
	public static void swap(int[] nums,int i ,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		System.out.println(findKthLargest(nums,k));
	}

}
