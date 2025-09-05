import java.util.Arrays;

public class ProblemNo2749 {
    public static void main(String[] args) {
        ProblemNo2749.Solution a = new ProblemNo2749().new Solution();
        System.out.println(a.makeTheIntegerZero(85, 42));
    }

    class Solution {
        public int makeTheIntegerZero(int num1, int num2) {
            int i = 0;
            while(true){
                long val = num1 - (long)num2*i;
                if (val < i) return -1;
                if(Long.bitCount(val) <= i) return i;

                i++;
            }
        }

    }

}
