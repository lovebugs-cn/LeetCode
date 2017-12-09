package leetcode;

public class MaxArea {
	/*
	当左端线段L小于右端线段R时，把L右移，
	这时舍弃的是L与右端其他线段（R-1, R-2, ...）组成的木桶，这些木桶是没必要判断的，
	因为这些木桶的容积肯定都没有L和R组成的木桶容积大。
	*/
	public static int maxArea(int[] height) {
		
		if(height.length < 2)
			return 0;
		
		int i = 0;
		int j = height.length - 1;
		
		int maxarea = 0;
		while(i < j) {
			
			int area = Math.min(height[i], height[j]) * (j - i);
			if(area > maxarea)
				maxarea = area;
			
			if(height[i] < height[j])
				i ++;
			else
				j --;
		}
		
		return maxarea;
		
	}
	
	
	public static void main(String[] args) {
		int[] height = {1,1};
		System.out.println(maxArea(height));
	}
	

}
