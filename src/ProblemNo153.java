import java.util.Arrays;

public class ProblemNo153 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findMin(int[] nums) {
            int low = 0,  high = nums.length - 1;
            int last = nums[nums.length - 1];

            while (low < high) {
                int mid = (high + low) >> 1;

                if (nums[mid] > last) low = mid + 1;
                else high = mid;
            }

            return nums[low];
        }
    }

    // one line Answer 😁😁 but time complexity is O(n)
    class Solution_ {
        public int findMin(int[] nums) {
            return Arrays.stream(nums).min().getAsInt();
        }
    }

}
