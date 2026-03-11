public class ProblemNo1009 {
    public static void main(String[] args) {



    }

    class Solution {
        public int bitwiseComplement(int n) {
            if (n == 0) return 1;
            int extra = 1;
            while (extra - 1 < n){
                extra = extra << 1;
            }

            return extra - n - 1;
        }
    }

}
