public class ProblemNo1464 {
    class Solution {
        public int maxProduct(int[] nums) {
            int secondLargest = 0, largest = 0;

            for (int i : nums) {
                if (i > largest) {
                    secondLargest = largest;
                    largest = i;
                } else if (i > secondLargest)
                    secondLargest = i;
            }

            return (secondLargest - 1) * (largest - 1);

        }
    }
}
