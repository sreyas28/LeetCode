public class ProblemNo3753 {
    public static void main(String[] args) {
        Solution a = new ProblemNo3753().new Solution();
        System.out.println(a.totalWaviness(121, 121));
    }

    class Solution {
        public long totalWaviness(long num1, long num2) {
            long Val = recursion(Long.toString(num2), 0, true, -1, -1, true);
            Val -= recursion(Long.toString(num1-1), 0, true, -1, -1, true);

            return Val;
        }

        private long recursion(String num, int pos, boolean tight, int prev, int prevPrev, boolean leadingZero) {
            if ((leadingZero && pos >= num.length() - 2) || pos >= num.length()) return 0;
            long ans = 0;
            int end = tight ? num.charAt(pos) - '0' : 9;

            boolean condition = prev != -1 && prevPrev != -1 && prev != prevPrev;

            for (int curr = 0; curr <= end; curr++) {
                if (condition) {
                    if (prevPrev < prev && prev > curr) ans++;
                    else if (prevPrev > prev && prev < curr) ans++;
                }

                ans += recursion(
                        num,
                        pos + 1,
                        tight && curr == num.charAt(pos) - '0',
                        curr,
                        prev,
                        leadingZero && curr == 0);
            }

            return ans;
        }
    }

}
