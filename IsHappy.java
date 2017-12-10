package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IsHappy {

    public static boolean isHappy(int n){

        List<Integer> list = new ArrayList<Integer>();

        int sum = 0;
        while(!list.contains(sum)){
            list.add(sum);
            sum = 0;

            while(n > 0){
                int y = n % 10;
                sum += y * y;
                n = n / 10;
            }
            n = sum;
            if(sum == 1)
                return true;

        }

        return false;

    }

    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }
}
