public class ProblemNo2243 {
    public static void main(String[] args) {

        Solution a = new ProblemNo2243().new Solution();
        System.out.println(a.digitSum("111112222", 3));

    }

    class Solution {
        public String digitSum(String s, int k) {
            while (s.length() > k) {
                StringBuilder temp = new StringBuilder();
                int len = s.length(), i = 0, sum = 0;

                while (i < len) {
                    sum += s.charAt(i) - '0';

                    if ((i + 1) % k == 0) {
                        temp.append(sum);
                        sum = 0;
                    }

                    i++;
                }

                if (len % k != 0) temp.append(sum);

                s = temp.toString();
            }


            return s;
        }
    }

}
