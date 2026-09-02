public class ProblemNo3875 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3875().new Solution();
        System.out.println(a.uniformArray(new int[]{2,3}));
        System.out.println(a.uniformArray(new int[]{2,4}));

    }

    class Solution {
        public boolean uniformArray(int[] nums) {
            return true;
        }
    }

    class Solution_ {
        public boolean uniformArray(int[] nums) {
            int odd1 = -1, odd2 = -1;

            for (int num : nums) {
                if (num % 2 == 1) {
                    if (odd1 == -1) odd1 = num;
                    else if (odd2 == -1) odd2 = num;
                }
            }

            // Let's make it odd
            boolean allOdd = odd1 != -1;

            // Let's make it even
            boolean allEven = (odd1 != -1 && odd2 != -1) || (odd1 == -1 && odd2 == -1);

            return allOdd || allEven;
        }
    }

}
