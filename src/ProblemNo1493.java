import java.util.ArrayList;

public class ProblemNo1493 {
    public static void main(String[] args) {

        ProblemNo1493.Solution a = new ProblemNo1493().new Solution();
        System.out.println(a.longestSubarray(new int[] {1,1,1,1} ));

    }

    class Solution {
        public int longestSubarray(int[] nums) {
            ArrayList<Integer> list = new ArrayList<>();

            int count = 0;
            for(int num: nums){
                if (num == 1) count++;
                else {
                    list.add(count);
                    count = 0;
                }
            }
            list.add(count);

            int result = 0;
            if(list.size() != 1){
                for (int i = 1; i < list.size(); i++) {
                    result = Math.max(result, list.get(i - 1) + list.get(i));
                }
            }
            else result = list.getFirst()-1;

            return result;
        }
    }

}
