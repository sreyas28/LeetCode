public class ProblemNo2161 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] pivotArray(int[] nums, int pivot) {
            final int N = nums.length;
            int[] result = new int[N];

            int left = 0, right = N - 1;

            for(int i = 0, j = N-1; i < N; i++, j--) {
                if(nums[i] < pivot) result[left++] = nums[i];
                if (nums[j] > pivot)  result[right--] = nums[j];
            }

            while(left <= right) {
                result[left++] = pivot;
            }

            return result;
        }
    }

}
