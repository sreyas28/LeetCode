import java.util.*;

public class ProblemNo229 {
    public static void main(String[] args) {

        ProblemNo229.Solution p = new ProblemNo229().new Solution();
        System.out.println(p.majorityElement(new int[]{3, 2, 3}));

    }

    class Solution {
        public List<Integer> majorityElement(int[] nums) {

            int candidate_1 = -1;
            int candidate_2 = -1;
            int candidate_1_count = 0;
            int candidate_2_count = 0;

            for (int num : nums) {
                if (candidate_1 == num) candidate_1_count++;
                else if (candidate_2 == num) candidate_2_count++;
                else if (candidate_1_count == 0) {
                    candidate_1 = num;
                    candidate_1_count++;
                }
                else if (candidate_2_count == 0) {
                    candidate_2 = num;
                    candidate_2_count++;
                }
                else {
                    candidate_1_count--;
                    candidate_2_count--;
                }
            }

            candidate_1_count = 0;
            candidate_2_count = 0;

            for (int num : nums) {
                if (candidate_1 == num) candidate_1_count++;
                else if (candidate_2 == num) candidate_2_count++;
            }

            List<Integer> res = new ArrayList<>();

            int lowerBound = Math.floorDiv(nums.length, 3);
            if (candidate_1_count > lowerBound) res.add(candidate_1);
            if (candidate_2_count > lowerBound) res.add(candidate_2);

            return res;
        }
    }

}
