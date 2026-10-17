import java.util.*;

public class ProblemNo3551 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3551().new Solution();
//        System.out.println(a.minSwaps(new int[]{37, 100}));
        System.out.println(a.minSwaps(new int[]{18, 43, 34, 16}));

    }

    class Solution {
        public int minSwaps(int[] nums) {
            final int N = nums.length;
            List<Integer> sortedNums = new ArrayList<>();

            Map<Integer, Integer> numIndex = new HashMap<>();

            for (int i = 0; i < N; i++) {
                sortedNums.add(nums[i]);
                numIndex.put(nums[i], i);
            }

            sortedNums.sort((x, y) -> {
                int digitSumA = getDigitSum(x);
                int digitSumB = getDigitSum(y);

                if (digitSumA == digitSumB) return x - y;
                else return digitSumA - digitSumB;
            });

            int count = 0;
            for (int currentIndex = 0; currentIndex < N; currentIndex++) {
                int expectedValue = sortedNums.get(currentIndex);
                int currentValue = nums[currentIndex];

                if (expectedValue == currentValue) continue;

                int expectedIndex = numIndex.get(expectedValue);

                // swap
                nums[currentIndex] = expectedValue;
                nums[expectedIndex] = currentValue;

                // map update
                numIndex.put(expectedValue, currentIndex);
                numIndex.put(currentValue, expectedIndex);

                count++;
            }


            return count;
        }

        private int getDigitSum(int num) {
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }

            return sum;
        }

    }

}
