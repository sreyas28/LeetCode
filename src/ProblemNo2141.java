import java.util.*;

public class ProblemNo2141 {
    public static void main(String[] args) {

        ProblemNo2141.Solution a = new ProblemNo2141().new Solution();
        System.out.println(a.maxRunTime(2, new int[]{3,3,3}));

    }

    class Solution {
        public long maxRunTime(int n, int[] batteries) {
            long total = 0;
            for(int i: batteries) total += i;

            long left = 0, right = total / n;
            while(left < right){
                long mid = (right + left)/2;

                if(canRun(mid,n,batteries)) left = mid;
                else right = mid - 1;
            }

            return left;
        }

        private boolean canRun(long time, int n, int[] batteries){
            long sum = 0;
            for(int bat: batteries) sum += Math.min(bat, time);

            return sum >= (long) n*time;
        }
    }

    // brute force
    class Solution_ {
        public long maxRunTime(int n, int[] batteries) {
            PriorityQueue<Integer> queue = new PriorityQueue<>( (a,b) -> b - a );
            for(int i: batteries) queue.offer(i);
            if(queue.size() < n) return 0;

            int computersOnline = 0;
            while(true){
                List<Integer> values = new ArrayList<>();
                boolean cont = true;
                for(int i=0; i<n; i++){
                    int val = queue.poll();
                    if(val == 0){
                        cont = false;
                        break;
                    }
                    values.add(val-1);
                }
                if(!cont) break;
                for(int i: values) queue.offer(i);

                computersOnline++;
            }

            return computersOnline;
        }
    }
}
