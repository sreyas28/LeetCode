import java.util.*;

public class ProblemNo3318 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] findXSum(int[] nums, int k, int x) {
            int len = nums.length;
            int[] result = new int[len - k + 1];

            for(int i = 0; i <= len - k; i++){
                Map<Integer, Integer> freq = new HashMap<>();
                for(int num = i; num < k + i; num++) freq.put(nums[num], freq.getOrDefault(nums[num], 0) + 1);

                PriorityQueue<int[]> sortFreq = new PriorityQueue<>( (a, b) -> a[1] != b[1] ? b[1] - a[1]: b[0] - a[0]);
                for(int key: freq.keySet()){
                    sortFreq.add(new int[] {key, freq.get(key)});
                }

                for(int j = 0; j < x; j++){
                    int[] val = sortFreq.poll();

                    if(val == null) val = new int[2];
                    result[i] += val[0]*val[1];
                }
            }
            return result;
        }
    }

}
