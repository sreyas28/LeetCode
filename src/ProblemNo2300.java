import java.util.Arrays;

public class ProblemNo2300 {

    public static void main(String[] args) {

        ProblemNo2300.Solution a = new ProblemNo2300().new Solution();
        System.out.println(Arrays.toString(a.successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16)));

    }

    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int len = potions.length;
            int[] result = new int[spells.length];

            Arrays.sort(potions);

            for(int i = 0; i<spells.length; i++){
                double num = (double) success / spells[i];

                int left = 0;
                int right = len - 1;

                while(left <= right){
                    int mid = left + (right-left)/2;

                    if(potions[mid] >= num) right = mid - 1;
                    else left = mid + 1;
                }

                result[i] = len-left;
            }

            return result;
        }
    }

}
