import java.util.ArrayList;

public class ProblemNo2210 {

    public static void main(String[] args) {

        ProblemNo2210.Solution a = new ProblemNo2210().new Solution();
        System.out.println(a.countHillValley(new int[]{2,4,1,1,6,5}));

    }

    class Solution {
        public int countHillValley(int[] nums) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[0]);

            for(int i: nums){
                if(i != list.getLast()) list.add(i);
            }
            System.out.println(list);

            int count = 0;
            for(int i=1; i<list.size() - 1; i++){
                if(list.get(i) > list.get(i+1) && list.get(i) > list.get(i-1)) count++;
                else if(list.get(i) < list.get(i+1) && list.get(i) < list.get(i-1)) count++;
            }

            return count;
        }
    }

}
