import java.util.*;

public class ProblemNo1296 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1296().new Solution();
        System.out.println(a.isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4));
        System.out.println(a.isPossibleDivide(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3));
        System.out.println(a.isPossibleDivide(new int[]{1, 2, 3, 4}, 3));

    }

    class Solution {
        public boolean isPossibleDivide(int[] nums, int k) {
            Map<Integer, Integer> freq = new TreeMap<>();
            for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

            for (int key : freq.keySet()) {
                if (freq.get(key) == 0) continue;

                int temp = freq.get(key);

                for (int i = key + 1; i < key + k; i++) {
                    if (!freq.containsKey(i) || freq.getOrDefault(i,0) < temp) return false;
                    freq.put(i, freq.get(i) - temp);
                }
            }

            return true;
        }
    }



    // works but bit slow
    class Solution__ {
        public boolean isPossibleDivide(int[] nums, int k) {
            Map<Integer, Integer> freq = new TreeMap<>();
            Set<Integer> keySet = new TreeSet<>(freq.keySet());

            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
                keySet.add(num);
            }

            for (int key : keySet) {
                if (!freq.containsKey(key)) continue;
                int temp = freq.get(key);
                freq.remove(key);

                for (int i = key + 1; i < key + k; i++) {
                    if (!freq.containsKey(i)) return false;
                    freq.put(i, freq.getOrDefault(i, 0) - temp);

                    int temp_2 = freq.get(i);
                    if (temp_2 < 0) return false;
                    else if (temp_2 == 0) freq.remove(i);
                }
            }

            return true;
        }
    }


    //MLE
    class Solution_ {
        public boolean isPossibleDivide(int[] nums, int k) {
            int len = Arrays.stream(nums).max().getAsInt() + 2;

            int[] frequency = new int[len];
            for (int i : nums) frequency[i]++;

            int[] diff = new int[len];
            diff[0] = frequency[0];

            for (int i = 1; i < len; i++) diff[i] = frequency[i] - frequency[i - 1];

            int i = 0;
            while (i < len - 1) {
                if (diff[i] == 0) i++;
                else if (diff[i] <= 0) return false;
                else {
                    int temp = diff[i];
                    diff[i] -= temp;
                    if (i + k > len - 1) return false;
                    diff[i + k] += temp;

                    i++;
                }
            }

            return true;
        }
    }

}
