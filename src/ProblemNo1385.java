public class ProblemNo1385 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            int count = 0;

            for (int k : arr1) {
                boolean flag = true;
                for (int i : arr2) {
                    if (Math.abs(k - i) <= d) {
                        flag = false;
                        break;
                    }
                }
                if (flag) count++;
            }

            return count;
        }
    }

}
