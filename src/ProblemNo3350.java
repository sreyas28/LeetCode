import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemNo3350 {
    public static void main(String[] args) {

        ProblemNo3350.Solution a = new ProblemNo3350().new Solution();
        List<Integer> countAll = Arrays.asList(-15,19);
        System.out.println(a.maxIncreasingSubarrays(countAll));

    }

    class Solution {
        public int maxIncreasingSubarrays(List<Integer> nums) {

            List<Integer> countAll = new ArrayList<>();
            int count = 1;

            for(int i = 1; i < nums.size(); i++){
                if(nums.get(i-1) < nums.get(i)) count++;
                else {
                    countAll.add(count);
                    count = 1;
                }
            }
            countAll.add(count);

            System.out.println(countAll);

            int max = countAll.getFirst()/2;
            for(int i=1; i<countAll.size(); i++){
                int a = countAll.get(i), b = countAll.get(i-1);

                if(a >= b) {
                    max = Math.max(max, a/2);
                    max = Math.max(max, b);
                }
                else{
                    max = Math.max(max, b/2);
                    max = Math.max(max, a);
                }
            }

            return max;
        }
    }

}
