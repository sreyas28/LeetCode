import java.util.ArrayList;
import java.util.List;

public class ProblemNo2553 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] separateDigits(int[] nums) {
            List<Integer> res = new ArrayList<>();

            for (int i : nums) {
                res.addAll(separator(i));
            }

            int[] ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }

            return ans;
        }

        private List<Integer> separator(int number) {
            List<Integer> list = new ArrayList<>();
            while (number > 0) {
                list.add(number % 10);
                number /= 10;
            }
            return list.reversed();
        }

    }

}
