import java.util.*;

public class ProblemNo3312 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3312().new Solution();
        System.out.println(Arrays.toString(a.gcdValues(new int[]{3,9}, new long[]{})));

    }

    class Solution {
        public int[] gcdValues(int[] nums, long[] queries) {
            int max = 0;
            for (int i: nums) max = Math.max(max, i);

            long[] freq = new long[max + 1];
            for (int i: nums) freq[i]++; // only making the frequency

            for (int i = 1; i <= max; i++) {
                for (int j = i * 2; j <= max; j += i) freq[i] += freq[j]; // adding multiple of the i number
            }

            for (int i = 1; i <= max; i++) freq[i] = freq[i] * (freq[i] - 1) / 2; // adding all the pairs

            for (int i = max; i >= 1; i--) {
                for (int j = i * 2; j <= max; j += i) freq[i] -= freq[j]; // removing extra multiple
            }

            for (int i = 1; i <= max; i++) freq[i] += freq[i - 1]; // prefix sum

            int[] ans = new int[queries.length];
            for (int k = 0; k < queries.length; k++) {
                long q = queries[k] + 1;
                int left = 1, right = max;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (freq[mid] >= q) right = mid;
                    else left = mid + 1;
                }
                ans[k] = left;
            }
            return ans;
        }
    }

    // wrong
    class Solution__ {
        public int[] gcdValues(int[] nums, long[] queries) {
            final int N = nums.length;

            int max = 0;
            Map<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                max = Math.max(max, num);
            }

            List<Integer> list = new ArrayList<>();

            int rest = N;
            for (int key : map.keySet()) {
                int value = map.get(key);

                if (key == 1) {
                    int ones = (value * (value - 1) / 2) + (rest - value);
                    repeat(1, ones, list);
                }

                else {
                    int count = 0;
                    for (int val = key * 2, i = 3; val <= max; val = key * i, i++) {
                        if (map.containsKey(val)) count += map.get(val);
                    }

                    int ones = (rest - value - count) * value;
                    int keyVal = count + (value * (value - 1) / 2);

                    repeat(1, ones, list);
                    repeat(key, keyVal, list);
                }

                rest -= value;
            }

            list.sort((a,b) -> a-b);

            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) ans[i] = list.get((int)queries[i]);

            return ans;
        }

        private void repeat(int value, int times, List<Integer> list) {
            for (int i = 0; i < times; i++) {
                list.add(value);
            }
        }

    }

}
