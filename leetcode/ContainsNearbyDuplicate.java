package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate {

    public static boolean containsNearbyDuplicate(int[] nums, int k){

        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i ++){

            if (i > k)
                set.remove(nums[i - k - 1]);

            if (set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

}
