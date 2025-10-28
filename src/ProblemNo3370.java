public class ProblemNo3370 {
    public static void main(String[] args) {

    }

    class Solution {
        public int smallestNumber(int n) {
            if(n == 1) return 1;

            if(n % 2 == 0) n++;
            int power = (int) Math.ceil(Math.log(n)/Math.log(2));

            return (int) Math.pow(2,power) - 1;
        }
    }

}
