import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ProblemNo2200 {
    public static void main(String[] args) {

        ProblemNo2200.Solution a = new ProblemNo2200().new Solution();
        System.out.println(a.findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9, 1));

    }

    class Solution {
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            int n = nums.length;
            HashSet<Integer> temp = new HashSet<>();

            for(int i = 0; i < n; i++){
                if(nums[i] == key){
                    for(int j = 0; j <= k; j++){
                        int a = i + j, b = i - j;
                        if(a < n) temp.add(a);
                        if(b >= 0) temp.add(b);
                    }
                }
            }

            List<Integer> result = new ArrayList<>(temp);
            Collections.sort(result);

            return result;

        }
    }

}
