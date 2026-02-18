public class ProblemNo693 {
    public static void main(String[] args) {

    }


    class Solution {
        public boolean hasAlternatingBits(int n) {
            if ( n == 0) return true;

            boolean LSB = (n & 1) == 1; // false == 0 and true == 1
            n = n >> 1;
            while (n!=0){
                if ((n&1)==1 && LSB) return false;
                else if ((n&1)==0 && !LSB) return false;

                LSB = (n&1) == 1;

                n = n >> 1;
            }

            return true;
        }
    }

    // kind -a brute force TLE
    class Solution_ {
        public boolean hasAlternatingBits(int n) {

            int a = 0;
            int b = 1;

            while (true) {
                if (a == n || b == n) return true;

                if ((a & 1) == 0) a = (a << 1) + 1;
                else a = (a << 1);

                if ((b & 1) == 0) b = (b << 1) + 1;
                else b = (b << 1);

                if (a > n && b > n) return false;
            }
        }
    }

}
