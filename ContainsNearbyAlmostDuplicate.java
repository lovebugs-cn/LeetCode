package leetcode;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){

        if(k<1||t<0) return false;

        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(i>k)
                set.remove(nums[i-k-1]);
            int n = nums[i];
            if((set.floor(n)!=null&& n<=t+set.floor(n))||(set.ceiling(n)!=null && n >= set.ceiling(n)-t))
                return true;
            set.add(n);

        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        int k = 1;
        int t = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}
