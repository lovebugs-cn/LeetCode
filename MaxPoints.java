import java.util.HashMap;
import java.util.Map;

public class MaxPoints {

    static class Point{
        int x;
        int y;
        Point(){
            x = 0;
            y = 0;
        }
        Point(int a, int b){
            x = a;
            y = b;
        }
    }

    public static int maxPoints(Point[] points){

        if (points.length < 3)
            return points.length;

        int max = 0;
        Map<Double,Integer> map = new HashMap<Double, Integer>();

        for (int i = 0; i < points.length; i ++){
            map.clear();
            int duplicate = 1;//记录与固定点重合的个数
            for (int j = 0; j < points.length; j ++){
                if (i == j)
                    continue;//跳过自身
                double slope = 0.0;
                if (points[i].x == points[j].x && points[i].y == points[j].y){
                    duplicate ++;
                    continue;
                }
                else if (points[i].x == points[j].x)
                    slope = Integer.MAX_VALUE;
                else
                    slope = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);//注意转成double型

                map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);
            }

            if (map.size() == 0)
                max = duplicate > max ? duplicate : max;
            else{
                for (int val : map.values()) {
                    max = Math.max((duplicate + val), max);
                }
            }

        }

        return max;
    }

    public static void main(String[] args) {
        /**Point[] points1 = {new Point(84,250), new Point(), new Point(1,0), new Point(0,-70), new Point(0,-70),
                new Point(1,-1),new Point(21,10),new Point(42,90),new Point(-42,-230)
        };*/
        Point[] points2 = {new Point(), new Point(94911151,94911150),new Point(94911152,94911151)};
        //System.out.println(maxPoints(points1));
        System.out.println(maxPoints(points2));
    }
}
