public class ProblemNo2040 {
    public static void main(String[] args) {

        ProblemNo2040.Solution a = new ProblemNo2040().new Solution();
        System.out.println(a.kthSmallestProduct(new int[]{-2,-1,0,1,2}, new int[]{-3,-1,2,4,5}, 3));

    }

    class Solution {
        public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
            long left = (long)-1e10, right = (long)1e10;

            while(left < right){
                long mid = left + (right - left) / 2;

                if(countLessOrZero(nums1, nums2, mid) < k) left = mid + 1;
                else right = mid;
            }

            return left;
        }

        private long countLessOrZero(int[] num1, int[] num2, long mid){
            long count = 0;
            for(int a: num1) {
                if (a >= 0) count += countPositive(num2, a, mid);
                else count += countNegative(num2, a, mid);
            }

            return count;
        }

        private long countPositive(int[] nums,int a,long mid){
            int low = 0, high = nums.length;

            while(low < high){
                int md = low + (high - low) / 2;

                if((long) a * nums[md] <= mid) low = md + 1;
                else high = md;
            }

            return low;
        }

        private long countNegative(int[] nums ,int a ,long mid){
            int low = 0, high = nums.length;

            while(low < high){
                int md = low + (high - low) / 2;

                if((long) a * nums[md] <= mid) high = md;
                else low = md + 1;
            }

            return nums.length - low;
        }


    }

}
