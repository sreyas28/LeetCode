public class ProblemNo42 {
    public static void main(String[] args) {

        Solution a = new ProblemNo42().new Solution();
//        System.out.println(a.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println(a.trap(new int[]{4,2,3}));
        System.out.println(a.trap(new int[]{3,2,1,2,1}));
//        System.out.println(a.trap(new int[]{0,2,0}));

    }

    class Solution {
        public int trap(int[] height) {
            final int n = height.length;
            int ans = 0;

            int i = 0;
            int cur = 0, curIndex = -1;
            while (i < n){
                int curSum = 0, j = i;
                int localMax = 0;

                for (; j < n; j++){
                    if (height[j] >= cur){
                        cur = height[j];
                        curIndex = j;

                        ans += curSum;
                        curSum = 0;
                    }
                    else {
                        curSum += cur - height[j];
                        localMax = Math.max(localMax, height[j]);
                    }
                }
                i = curIndex + 1;
                cur = localMax;
            }

            return ans;
        }
    }

}
