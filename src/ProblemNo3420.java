import java.util.ArrayDeque;
import java.util.Deque;

public class ProblemNo3420 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3420().new Solution();
//        System.out.println(a.countNonDecreasingSubarrays(new int[]{6, 3, 1, 2, 4, 4}, 7));
//        System.out.println(a.countNonDecreasingSubarrays(new int[]{1000000000, 1, 1, 1, 1}, 1000000000));
//        System.out.println(a.countNonDecreasingSubarrays(new int[]{12,3,14,18}, 1));
        System.out.println(a.countNonDecreasingSubarrays(new int[]{6, 3, 1, 3, 6}, 4));

    }


    class Solution {
        public long countNonDecreasingSubarrays(int[] nums, int k) {
            final int N = nums.length;

            long result = 0;
            long operations = 0;

            Deque<int[]> deQue = new ArrayDeque<>(); // {value, freq}

            for (int left = N - 1, right = N - 1; left >= 0; left--) {
                int currVal = nums[left];
                int freq = 1;

                while (!deQue.isEmpty() && currVal > deQue.peekFirst()[0]) {
                    int[] a = deQue.pollFirst();

                    operations += (long) (currVal - a[0]) * a[1];
                    freq += a[1];
                }

                if (!deQue.isEmpty() && currVal == deQue.peekFirst()[0]) {
                    int[] a = deQue.pollFirst();
                    a[1] += freq;
                    deQue.addFirst(a);
                } else deQue.addFirst(new int[]{currVal, freq});

                while (operations > k && left <= right && !deQue.isEmpty()) {
                    int[] a = deQue.pollLast();

                    operations -= (a[0] - nums[right]);
                    a[1]--;

                    if (a[1] != 0) deQue.addLast(a);
                    right--;
                }
                if (operations <= k) result += (right - left + 1);
            }

            return result;
        }
    }

    // brute force O(n^2) TLE :(
    class Solution_ {
        public long countNonDecreasingSubarrays(int[] nums, int k) {
            long count = 0;

            for (int i = 0; i < nums.length; i++) {
                int max = nums[i];
                int tempK = k;

                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] >= max) max = nums[j];
                    else {
                        int incr = max - nums[j];

                        if (incr > tempK) break;
                        else tempK -= incr;
                    }
                    count++;
                }
            }

            return count + nums.length;
        }
    }

}
