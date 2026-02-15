public class ProblemNo67 {
    public static void main(String[] args) {

        ProblemNo67.Solution p = new ProblemNo67().new Solution();
        System.out.println(p.addBinary("1010", "101"));

    }

    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int carry = 0;

            int a_iterate = a.length() - 1, b_iterate = b.length() - 1;
            while (a_iterate >= 0 || b_iterate >= 0 || carry == 1) {

                int sum = carry;
                if(a_iterate >= 0) sum +=  a.charAt(a_iterate--) - '0';
                if(b_iterate >= 0) sum +=  b.charAt(b_iterate--) - '0';

                sb.append(sum % 2);
                carry = sum / 2;
            }

            return sb.reverse().toString();
        }
    }


}
