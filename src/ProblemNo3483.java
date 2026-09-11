import java.util.HashSet;
import java.util.Set;

public class ProblemNo3483 {
    public static void main(String[] args) {

    }


    // somewhat optimized as its complexity is always O(1000)
    class Solution {
        public int totalNumbers(int[] digits) {
            int[] nums = new int[10];
            for (int i : digits) nums[i]++;

            int count = 0;
            for (int unit = 0; unit < 10; unit += 2) {
                if (nums[unit] == 0) continue;
                nums[unit]--;

                for (int ten = 0; ten < 10; ten++) {
                    if (nums[ten] == 0) continue;
                    nums[ten]--;

                    for (int hundred = 1; hundred < 10; hundred++) {
                        if (nums[hundred] == 0) continue;
                        count++;
                    }
                    nums[ten]++;
                }
                nums[unit]++;
            }

            return count;
        }
    }

    // brute Force
    class Solution_ {
        public int totalNumbers(int[] digits) {
            final int N = digits.length;
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < N; i++) {
                if (digits[i] == 0) continue;

                for (int j = 0; j < N; j++) {
                    if (i == j) continue;

                    for (int k = 0; k < N; k++) {
                        if (k == i || k == j) continue;
                        int number = digits[i] * 100 + digits[j] * 10 + digits[k];

                        if (number % 2 == 0) set.add(number);

                    }
                }
            }

            return set.size();
        }
    }

}
