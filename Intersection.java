package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
	
	public static int[] intersection(int[] nums1,int[] nums2) {
		
		Set<Integer> numSet = new HashSet<Integer>();
		Set<Integer> result = new HashSet<Integer>();
		
		for(int i = 0; i < nums1.length; i ++)
			numSet.add(nums1[i]);
		
		for(int j = 0; j < nums2.length; j ++) {
			if(numSet.contains(nums2[j]))
				result.add(nums2[j]);
		}
		
		int[] res = new int[result.size()];
		int index = 0;
		
		for(Integer num : result)
			res[index++] = num;
		
		return res;
		
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] res = intersection(nums1,nums2);
		System.out.println(Arrays.toString(res));
 	}

}
