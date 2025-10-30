import java.util.Arrays;

public class ProblemNo1526 {
    public static void main(String[] args) {
        ProblemNo1526.Solution a = new ProblemNo1526().new Solution();
        System.out.println(a.minNumberOperations(new int[]{5,4,2}));
    }

    // O(n)
    class Solution {
        public int minNumberOperations(int[] target) {
            int result = target[0];
            for(int i = 1; i < target.length; i++){
                result += Math.max(target[i] - target[i-1], 0);
            }
            return result;
        }
    }
    // O(n^2)
    class Solution_ {

        private int[] numbers;

        public int minNumberOperations(int[] target) {
            this.numbers = target;
            return divider(0, target.length-1, minPosition(0, target.length-1));
        }

        private int divider(int start, int end, int minIndex){
            if( start >= end) return numbers[minIndex];

            int minVal = numbers[minIndex];
            for(int i = start; i <= end; i++){
                this.numbers[i] -= minVal;
            }

            int left = 0, right = 0;
            if(minIndex - 1 >= start){
                int currentMinIndexLeft = minPosition(start, minIndex - 1);
                left = divider(start, minIndex - 1, currentMinIndexLeft);
            }
            if(minIndex + 1 <= end){
                int currentMinIndexRight = minPosition(minIndex + 1, end);
                right = divider(minIndex + 1, end, currentMinIndexRight);
            }

            return minVal + left + right;
        }

        private int minPosition(int start, int end){
            int minIndex = start;

            for(int i = start; i <= end; i++){
                minIndex = numbers[minIndex] >= numbers[i] ? i : minIndex;
            }

            return minIndex;
        }
    }

}
