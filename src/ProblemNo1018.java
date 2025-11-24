import java.util.*;

public class ProblemNo1018 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<Boolean> prefixesDivBy5(int[] nums) {
            List<Boolean> result = new ArrayList<>();
            int val = 0;
            for(int i: nums){
                val = ((val << 1) + i) % 5;
                result.add(val == 0);
            }
            return result;
        }
    }

}
