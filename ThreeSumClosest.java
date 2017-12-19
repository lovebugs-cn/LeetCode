import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target){

        int dif = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i ++){
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum - target == 0)
                    return target;

                if(Math.abs(sum - target) < dif){
                    dif = Math.abs(sum - target);
                    res = sum;
                }

                if(sum > target)
                    k --;
                else
                    j ++;

            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,-1,-1,3};
        int target = -1;
        System.out.println(threeSumClosest(nums,target));
    }
}
