public class ProblemNo3360 {

    public static void main(String[] args) {

    }

    class Solution {
        public boolean canAliceWin(int n) {

            for (int i = 10; i >= 1; i -= 2) {
                n -= i;
                if (n < 0) return false;
                n -= (i - 1);
                if (n < 0) return true;
            }

            return false;
        }
    }

}