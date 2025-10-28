import java.util.Arrays;

public class ProblemNo167 {
    public static void main(String[] args) {
        ProblemNo167.Solution a = new ProblemNo167().new Solution();
        System.out.println(Arrays.toString(a.twoSum(new int[]{5,25,75}, 100)));
    }

    class Solution {
        public int[] twoSum(int[] numbers, int target) {

            for(int i = 0; i < numbers.length; i++){
                int toFind = target - numbers[i];

                int val = ToFind(numbers, i+1, toFind);

                if(val != Integer.MIN_VALUE) return new int[]{i+1, val+1};
            }


            return null;
        }

        private int ToFind(int[] number, int left, int toFind){
            int right = number.length - 1;

            while(left <= right){
                int mid = left + (right - left) / 2;

                if(number[mid] == toFind) return mid;
                else if(number[mid] > toFind) right = mid - 1;
                else left = mid + 1;
            }

            return Integer.MIN_VALUE;
        }
    }

}
