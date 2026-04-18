import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ProblemNo3761 {
    public static void main(String[] args) {

    }

    class Solution {
        Map<Integer, Integer> reverseMap;

        public int minMirrorPairDistance(int[] nums) {
            reverseMap = new HashMap<>();
            Map<Integer, PriorityQueue<Integer>> forwardMap = new HashMap<>();
            int minDiff = Integer.MAX_VALUE;

            for(int i = 0; i < nums.length; i++) forwardMap.computeIfAbsent(nums[i], k -> new PriorityQueue<>()).add(i);

            for (int i = 0; i < nums.length; i++) {
                int currNum = nums[i];

                int to_find = reverseMap.getOrDefault(currNum, reverse(currNum));
                forwardMap.get(currNum).poll();

                if(forwardMap.get(currNum).isEmpty()) forwardMap.remove(currNum);

                if (forwardMap.containsKey(to_find)) {
                    int temp =  forwardMap.get(to_find).peek();
                    minDiff = Math.min(minDiff, temp - i);
                }
            }


            return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
        }

        private int reverse(int num){
            int key = num;
            int newNum = 0;

            while(num > 0 ){
                newNum = newNum * 10 + num % 10;
                num = num / 10;
            }

            reverseMap.put(key, newNum);
            return newNum;
        }

    }

}
