import java.util.Arrays;

public class ProblemNo1979 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findGCD(int[] nums) {
            int min = Arrays.stream(nums).min().getAsInt();
            int max = Arrays.stream(nums).max().getAsInt();

            return GCD(min, max);
        }

        private int GCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }

}
