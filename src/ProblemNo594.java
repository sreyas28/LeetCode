
import java.util.HashMap;

public class ProblemNo594 {
    public static void main(String[] args) {
        ProblemNo594.Solution a = new ProblemNo594().new Solution();

        System.out.println(a.findLHS(new int[]{1,1,1,1}));

    }

    class Solution {
        public int findLHS(int[] nums) {
            HashMap<Integer, Integer> frequency = new HashMap<>();

            for(int i: nums) frequency.put(i, frequency.getOrDefault(i, 0) + 1);
            System.out.println(frequency);

            int result = Integer.MIN_VALUE;
            for(int key: frequency.keySet()){
                int tempResult = 0;
                if(frequency.containsKey(key+1)) tempResult = frequency.get(key) + frequency.get(key + 1);
                if(tempResult > result) result = tempResult;
            }

            return result;
        }
    }

}
