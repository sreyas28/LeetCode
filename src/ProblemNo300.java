import java.util.*;

public class ProblemNo300 {
    public static void main(String[] args) {

        Solution a = new ProblemNo300().new Solution();
        System.out.println(a.lengthOfLIS(new int[]{4,10,4,3,8,9}));

    }

    class Solution {
        public int lengthOfLIS(int[] nums) {
            List<Integer> list = new ArrayList<>();

            list.add(nums[0]);

            for  (int i = 1; i < nums.length; i++) {
                if (list.getLast() < nums[i]) list.add(nums[i]);
                else {
                    int val = nums[i];
                    int left = 0, right = list.size()-1;

                    // we have to find a value in the list that is just greater or equal to val

                    while (left < right) {
                        int mid = left + (right - left)/2;

                        if (list.get(mid) >= val) right = mid;
                        else left = mid + 1;
                    }

                    list.set(left,val);
                }
            }

            return list.size();
        }
    }

}
