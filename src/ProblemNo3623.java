import java.util.*;

public class ProblemNo3623 {
    public static void main(String[] args) {
        ProblemNo3623.Solution a = new ProblemNo3623().new Solution();
        System.out.println(a.countTrapezoids(new int[][] {{1,0},{2,0},{3,0},{2,2},{3,2}} ));
    }

    class Solution {
        private int MOD = (int) (1e9 + 7);
        public int countTrapezoids(int[][] points) {
            HashMap<Integer, Integer> withY = new HashMap<>();

            for(int[] point: points){
                withY.put(point[1], withY.getOrDefault(point[1], 0) + 1);
            }

            long result = 0;
            long sum = 0;
            List<Long> arr = new ArrayList<>();

            for(int key: withY.keySet()){
                int n = withY.get(key);
                long value = ((long) n *(n-1) / 2) % MOD;
                arr.add(value);
                sum = (sum + value) % MOD;
            }

            for(long val: arr){
                sum -= val;
                result = (result + (val*sum)) % MOD;
            }

            return (int)(result % MOD);
        }
    }

}
