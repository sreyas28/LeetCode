import java.util.*;

public class ProblemNo3020 {
    public static void main(String[] args) {
        Solution a = new ProblemNo3020().new Solution();
        System.out.println(a.maximumLength(new int[] {4,5,1,2,2,4,16}));
    }

    class Solution {
        public int maximumLength(int[] nums) {
            int maxLen = 0;

            Map<Integer, Integer> intCount = new TreeMap<>();
            for (int i: nums) {
                if (i == 1) maxLen++;
                else intCount.put(i, intCount.getOrDefault(i, 0) + 1);
            }

            Set<Integer> seen = new HashSet<>();

            for (int key: intCount.keySet()) {
                if (seen.contains(key)) continue;

                int currLen = 0;
                int currKey = key; // *= 2;

                while (intCount.containsKey(currKey)) {
                    seen.add(currKey);

                    int curr = Math.min(intCount.get(currKey), 2);
                    currLen += curr;

                    if (curr < 2) break;

                    currKey = (int) Math.pow(currKey, 2);
                }

                maxLen = Math.max(maxLen, currLen);
            }

            return maxLen % 2 == 0 ? maxLen - 1 : maxLen;
        }
    }

}
