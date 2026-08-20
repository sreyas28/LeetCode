import java.util.ArrayList;
import java.util.List;

public class ProblemNo3069 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] resultArray(int[] nums) {
            final int N = nums.length;

            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();

            A.add(nums[0]);
            B.add(nums[1]);

            for (int i = 2; i < N; i++) {
                int lastA = A.getLast(), lastB = B.getLast();

                if (lastA > lastB) A.add(nums[i]);
                else B.add(nums[i]);
            }

            int i = 0;
            int[] res = new int[N];
            for(int x: A) res[i++] = x;
            for(int x: B) res[i++] = x;

            return res;
        }
    }

}
