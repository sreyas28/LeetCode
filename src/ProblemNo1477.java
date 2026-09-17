import java.util.Arrays;

public class ProblemNo1477 {
    public static void main(String[] args) {
        Solution a = new ProblemNo1477().new Solution();
        System.out.println(a.minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3));
        System.out.println(a.minSumOfLengths(new int[]{2, 1, 3, 3, 2, 3, 1}, 6));
        System.out.println(a.minSumOfLengths(new int[]{1, 1, 1, 1, 1}, 3));

    }

    class Solution {
        public int minSumOfLengths(int[] arr, int target) {
            int[] prevIndies = new int[arr.length];

            int left = 0, currSum = 0, result = Integer.MAX_VALUE, bestMin = Integer.MAX_VALUE;
            for (int right = 0; right < arr.length; right++) {
                currSum += arr[right];
                while (currSum > target) currSum -= arr[left++];

                if (currSum == target) {
                    int len = right - left + 1;

                    if (left - 1 > 0 && prevIndies[left - 1] != Integer.MAX_VALUE)
                        result = Math.min(result, prevIndies[left - 1] + len);

                    bestMin = Math.min(bestMin, len);
                }

                prevIndies[right] = bestMin;
            }

            return result == Integer.MAX_VALUE ? -1 : result;
        }
    }

}
