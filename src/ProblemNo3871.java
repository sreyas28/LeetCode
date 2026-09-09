public class ProblemNo3871 {

    public static void main(String[] args) {

        Solution a = new ProblemNo3871().new Solution();
        System.out.println(a.countCommas(1002));
        System.out.println(a.countCommas(998));
        System.out.println(a.countCommas(1000000));
        System.out.println(a.countCommas(1000000000));
        System.out.println(a.countCommas(999999999999900L));

    }

    class Solution {
        public long countCommas(long n) {
            long numbers = 1000, result = 0;

            while (n >= numbers) {
                result += n - numbers + 1;
                numbers *= 1000;
            }

            return result;
        }
    }

}
