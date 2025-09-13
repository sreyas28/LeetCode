import java.util.HashSet;
import java.util.Set;

public class ProblemNo287 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findDuplicate(int[] nums) {
            boolean[] seen = new boolean[nums.length + 1];

            for(int i: nums){
                if(seen[i]) return i;
                seen[i] = true;
            }

            return -1;
        }
    }

}
