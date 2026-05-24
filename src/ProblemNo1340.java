import java.util.Arrays;

public class ProblemNo1340 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1340().new Solution();
        System.out.println(a.maxJumps(new int[]{6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12}, 2));

    }

    class Solution {
        public int maxJumps(int[] arr, int d) {
            final int N = arr.length;
            int oldMax = 0;
            int[] oldDP = new int[N];

            Arrays.fill(oldDP, 1);

            for (int runner = 0; runner < N; runner++) {
                int currMax = 0;

                int[] newDP = new int[N];
                Arrays.fill(newDP, 1);

                for (int i = 0; i < N; i++) {
                    int curr = arr[i];

                    // left side
                    for (int j = i - 1, count = 0; j >= 0 && count < d; j--, count++) {
                        if (curr > arr[j]) {
                            newDP[i] = Math.max(1 + oldDP[j], newDP[i]);
                        } else break;
                    }

                    // right side
                    for (int j = i + 1, count = 0; j < N && count < d; j++, count++) {
                        if (curr > arr[j]) {
                            newDP[i] = Math.max(1 + oldDP[j], newDP[i]);
                        } else break;
                    }

                    currMax = Math.max(currMax, newDP[i]);
                }

                if (oldMax == currMax) break;

                oldMax = currMax;
                oldDP = Arrays.copyOf(newDP, N);
            }


            return oldMax;
        }
    }

}
