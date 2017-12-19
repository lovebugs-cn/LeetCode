import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

    public static int numberOfBoomerangs(int[][] points){

        int res = 0;

        for (int i = 0; i < points.length; i ++){
            Map<Integer,Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j < points.length; j ++){
                if (i == j)
                    continue;
                int dis = distance(points[i],points[j]);
                if (!map.containsKey(dis))
                    map.put(dis,1);
                else
                    map.put(dis, map.get(dis) + 1);
            }
            for (int val : map.values()){
                res += val * (val - 1);
            }
        }
        return res;
    }

    public static int distance(int[] a, int[] b){
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x*x + y*y;
    }

    public static void main(String[] args) {
        int[][] points = {{0,0}, {1,0}, {2,0}};
        System.out.println(numberOfBoomerangs(points));
    }
}
