public class ProblemNo2540 {
    public static void main(String[] args) {

    }

    class Solution {
        public int getCommon(int[] nums1, int[] nums2) {
            final int N = nums1.length;
            final int M = nums2.length;

            int i = 0, j = 0;
            while (i < N && j < M) {
                if (nums1[i] == nums2[j]) return nums1[i];
                else if (nums1[i] > nums2[j]) j++;
                else if (nums1[i] < nums2[j]) i++;
            }

            return -1;
        }
    }

}
