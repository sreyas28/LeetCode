public class ProblemNo1299 {

    public static void main(String[] args) {

    }

    class Solution {
        public int[] replaceElements(int[] arr) {
            int[] result = new int[arr.length];

            int maxRight = -1;

            for(int i = arr.length-1; i >= 0; i--){
                result[i] = maxRight;
                maxRight = Math.max(maxRight, arr[i]);
            }

            return result;
        }
    }

}
