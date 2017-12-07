package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersect {
	
	public static int[] intersect(int[] nums1,int[] nums2) {
		
		Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();
		List<Integer> result = new ArrayList<Integer>();
		
		for(int num : nums1) {
			if(!numMap.containsKey(num))
				numMap.put(num, 1);
			else
				numMap.put(num, numMap.get(num) + 1);
		}
		
		for(int num : nums2) {
			if(numMap.containsKey(num) && numMap.get(num) > 0) {
				result.add(num);
				numMap.put(num, numMap.get(num) - 1);
			}
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
		int[] res = intersect(nums1,nums2);
		System.out.println(Arrays.toString(res));
	}

}
