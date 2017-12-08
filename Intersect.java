package leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class Intersect {

    public static int[] intersection(int[] nums1,int[] nums2) {

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

    //第二种方法，将数组排序后进行查找
    public static int[] intersection2(int[] nums1,int[] nums2){

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<Integer>();

        int i = 0,j = 0;
        while(i < nums1.length && j < nums2.length){

            if(nums1[i] == nums2[j]){
                res.add(nums2[j]);
                i ++;
                j ++;
            }
            else if(nums1[i] < nums2[j])
                i ++;
            else
                j ++;

        }

        int[] result = new int[res.size()];
        int index = 0;
        for(Integer num : res)
            result[index ++] = num;

        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res1 = intersection(nums1,nums2);
        int[] res2 = intersection2(nums1,nums2);
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
    }

}
