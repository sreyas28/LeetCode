import java.util.HashSet;
import java.util.Set;

public class ProblemNo961 {
    public static void main(String[] args) {

    }

    class Solution {
        public int repeatedNTimes(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for(int i: nums){
                if(set.contains(i)) return i;
                else set.add(i);
            }

            return -1;
        }
    }

}
