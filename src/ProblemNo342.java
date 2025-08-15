public class ProblemNo342 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isPowerOfFour(int n) {
            if(n <= 0) return false;

            while(n % 4 == 0){
                n /= 4;
            }

            return n == 1;
        }
    }
}
