import java.util.*;

public class ProblemNo3625 {

    public static void main(String[] args) {

        ProblemNo3625.Solution a = new ProblemNo3625().new Solution();
        System.out.println(a.countTrapezoids(new int[][] {{96,75},{12,32},{96,32},{12,-53},{12,-24}}));

    }

    class Solution {
        public int countTrapezoids(int[][] points) {
            Map<Double, Map<Double, Integer>> slop_Y_freq = new HashMap<>();

            for(int i=0; i<points.length-1; i++){
                int x1 = points[i][0], y1 = points[i][1];

                for(int j = i+1; j < points.length; j++) {
                    int x2 = points[j][0], y2 = points[j][1];
                    int dx = x2-x1, dy = y2-y1;

                    double slop, intersection;
                    if(dx == 0){
                        slop = 1e9+7;
                        intersection = x1;
                    }
                    else{
                        slop = (double) dy/dx;
                        intersection = (double) (y1*dx - x1*dy) / dx;
                    }
                    Map<Double, Integer> temp = new HashMap<>();
                    if(slop_Y_freq.containsKey(slop)) temp = slop_Y_freq.get(slop);
                    temp.put(intersection, temp.getOrDefault(intersection, 0) + 1);

                    slop_Y_freq.put(slop,temp);
                }
            }

//            System.out.println(slop_Y_freq);

            int result = 0;
            for(double keyM: slop_Y_freq.keySet()){
                int prevHorizontalLine = 0;
                for(double key: slop_Y_freq.get(keyM).keySet()){
                    int count = slop_Y_freq.get(keyM).get(key);
                    result += count * prevHorizontalLine;

                    prevHorizontalLine += count;
                }

            }

            return result;
        }
    }

    class Solution__ {

        private final double INFINITY = 2001;

        public int countTrapezoids(int[][] points) {
            int n = points.length;
            Map<String, int[]> slopIndexPower = new HashMap<>();
            Set<String> goodSlop = new HashSet<>();
            Set<String> goodLine = new HashSet<>();

            for (int i=0; i<n; i++){
                Set<String> tempGoodLine = new HashSet<>();
                int x1 = points[i][0], y1 = points[i][1];

                for(int j=i+1; j<n; j++){
                    int x2 = points[j][0], y2 = points[j][1];
                    int top = y2-y1, down = x2-x1;

                    if(down == 0) {
                        top = 1;
                        down = 0;
                    }
                    else {
                        int g = gcd(top,down);
                        top /= g;
                        down /= g;
                    }

                    String line = down+"y-"+top+"x=" + (down * y2 - top*x1);
//                    System.out.println(line);

                    if(!goodLine.contains(line)){
                        String key = top + "/" + down;
                        if (slopIndexPower.containsKey(key)) goodSlop.add(key);
                        int[] val = slopIndexPower.getOrDefault(key, new int[n]);
                        val[i] = val[i] == 0 ? val[i] + 2: val[i] + 1;
                        slopIndexPower.put(key, val);
                        tempGoodLine.add(line);
                    }
                    goodLine.addAll(tempGoodLine);
                }
            }

//            for(String key: slopIndexPower.keySet()) System.out.println( key +" -> "+ Arrays.toString(slopIndexPower.get(key)));
//            System.out.println(goodSlop);

            int result = 0;
            for(String key: goodSlop){
                int[] array = slopIndexPower.get(key);
                int sum = 0;

                for(int i=0; i<n; i++){
                    array[i] = (array[i] *(array[i]-1) / 2);
                    sum += array[i];
                }

                for(int val: array){
                    sum -= val;
                    result = (result + (val*sum));
                }
            }

            return result;
        }

        private int gcd(int a, int b) {
            return b == 0 ? Math.abs(a) : gcd(b, a % b);
        }
    }

    class Solution_ {
        public int countTrapezoids(int[][] points) {
            Map<Double, Set<Integer>> slopPresentIndex = new HashMap<>();
            List<Map<Double, Integer>> slopCountWithIndex = new ArrayList<>();

            for(int i=0; i < points.length; i++){
                Map<Double, Integer> slopCount = new HashMap<>();
                int x1 = points[i][0], y1 = points[i][1];

                for(int j = i+1; j < points.length; j++){
                    int x2 = points[j][0], y2 = points[j][1];
                    int top = y2-y1, down = x2-x1;

                    if(down == 0) {
                        slopCount.put(2001.0, slopCount.getOrDefault(2001.0, 1) + 1);
                        slopPresentIndex.computeIfAbsent(2001.0, a -> new HashSet<>()).add(i);
                    }
                    else {
                        double val = (double) top / down;
                        slopCount.put(val , slopCount.getOrDefault(val, 1) + 1);
                        slopPresentIndex.computeIfAbsent(val, a -> new HashSet<>()).add(i);
                    }
                }
                slopCountWithIndex.add(slopCount);
            }

            slopCountWithIndex.removeLast();

            System.out.println(slopCountWithIndex);
            System.out.println(slopPresentIndex);

            return 0;
        }
    }

}
