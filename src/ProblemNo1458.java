import java.util.Arrays;
import java.util.HashMap;

public class ProblemNo1458 {
    public static void main(String[] args) {
        ProblemNo1458.Solution p = new ProblemNo1458().new Solution();
        System.out.println(p.maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}));
    }

    class Solution {

        HashMap<String, Integer> map = new HashMap<>();

        public int maxDotProduct(int[] nums1, int[] nums2) {
            int[][] products = new int[nums1.length][nums2.length];

            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    products[i][j] = nums1[i] * nums2[j];
                }
            }

            System.out.println(Arrays.deepToString(products));

            return trees(products, 0, 0, nums1, nums2);
        }

        private int trees(int[][] products, int i, int j, int[] num1, int[] num2) {

            String key = i + "," + j;
            if (map.containsKey(key)) return map.get(key);
            // taking this and nothing
            int sum1 = products[i][j];

            // taking only one of them
            if (i + 1 < num1.length) {
                int sum2 = trees(products, i + 1, j, num1, num2);
                sum1 = Math.max(sum1, sum2);
            }
            if (j + 1 < num2.length) {
                int sum2 = trees(products, i, j + 1, num1, num2);
                sum1 = Math.max(sum1, sum2);
            }

            // taking both
            if (i + 1 < num1.length && j + 1 < num2.length) {
                int sum2 = products[i][j] + trees(products, i + 1, j + 1, num1, num2);
                sum1 = Math.max(sum1, sum2);
            }

            map.put(key, sum1);
            return sum1;
        }
    }

}
