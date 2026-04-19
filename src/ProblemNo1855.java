public class ProblemNo1855 {
    public static void main(String[] args) {

        ProblemNo1855.Solution p = new ProblemNo1855().new Solution();

//        System.out.println(p.maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}));
        System.out.println(p.maxDistance(
                new int[]{9819,9508,7398,7347,6337,5756,5493,5446,5123,3215,1597,774,368,313},
                new int[]{9933,9813,9770,9697,9514,9490,9441,9439,8939,8754,8665,8560})
        );
    }

    class Solution {
        public int maxDistance(int[] nums1, int[] nums2) {
            int m = nums2.length;
            int outerLoop = Math.min(nums1.length, m);

            int maxVal = 0;

            for(int i = 0; i < outerLoop; i++){
                int val = nums1[i];

                int left = i, right = m - 1;
                while(left < right){
                    int mid =  Math.ceilDiv(left + right, 2);

                    if (val <= nums2[mid]) left = mid;
                    else right = mid - 1;
                }

                if (val <= nums2[left]) maxVal = Math.max(maxVal, left - i);
            }

            return maxVal;
        }
    }

}
