import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i ++){
            if(i > 0 && nums[i] == nums[i - 1])
                continue;//跳过相同的数字

            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];
            while (j < k){
                if(nums[j] + nums[k] == target){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j ++;
                    k --;
                    while (j < k && nums[j] == nums[j - 1])
                        j ++;//跳过相同的数字
                    while (j < k && nums[k] == nums[k + 1])
                        k --;
                }
                else if(nums[j] + nums[k] < target)
                    j ++;
                else
                    k --;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        System.out.println(threeSum(nums));
    }

}
