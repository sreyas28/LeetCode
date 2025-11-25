public class ProblemNo1015 {
    public static void main(String[] args) {

    }

    class Solution {
        public int smallestRepunitDivByK(int k) {
            if(k % 2 == 0 || k % 5 == 0) return -1;

            for(int i = 1,j = 1; i < 1e9; i = i*10 + 1, j++){
                if(i % k == 0) return j;
                else i %= k;
            }

            return -1;
        }
    }

}
