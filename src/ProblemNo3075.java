import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ProblemNo3075 {

    public static void main(String[] args) {
        ProblemNo3075.Solution a = new ProblemNo3075().new Solution();
        System.out.println(a.maximumHappinessSum(new int[]{1,2,3}, 2));
    }



    class Solution {
        public long maximumHappinessSum(int[] happiness, int k) {
            long sum = 0;
            Arrays.sort(happiness);  // ascending
            int len = happiness.length;

            int decrement = 0; // how many picks already made
            for (int i = len - 1; i >= len - k; i--) {
                int val = happiness[i] - decrement;
                if (val > 0) sum += val;
                decrement++;
            }

            return sum;
        }
    }


    // bit slow
    class Solution_ {
        public long maximumHappinessSum(int[] happiness, int k) {
            long sum = 0;
            PriorityQueue<Integer> vals = new PriorityQueue<>((a,b) -> b-a);
            for(int happy: happiness) vals.offer(happy);

            for(int i=0; i<k; i++) {
                int val = vals.isEmpty() ? 0 : vals.poll() - i;
                sum = val >= 0 ? sum + val : sum;
            }

            return sum;
        }
    }

}
