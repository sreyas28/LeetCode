public class ProblemNo190 {
    public static void main(String[] args) {
        ProblemNo190.Solution p = new ProblemNo190().new Solution();
        System.out.println(p.reverseBits(43261596));
    }

    class Solution {
        public int reverseBits(int n) {
            StringBuilder val = new StringBuilder(Integer.toBinaryString(n));
            int extra = 32 - val.length();
            for (int i = 0; i < extra; i++) val.insert(0, "0");
            val.reverse();

            int res = 0;
            for (char c : val.toString().toCharArray()) {
                if (c == '1') res = (res << 1) + 1;
                else res = res << 1;
            }

            return res;
        }
    }

}
