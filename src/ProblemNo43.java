import java.util.Arrays;
import java.util.Objects;

public class ProblemNo43 {
    public static void main(String[] args) {

        ProblemNo43.Solution a = new ProblemNo43().new Solution();
        System.out.println(a.multiply("123", "456"));

    }

    class Solution {
        public String multiply(String num1, String num2) {
            if(num1.equals("0") || num2.equals("0")) return "0";
            String Result = "0";

            for(int i=num2.length() -1, j = 0 ; i >=0 ; i--, j++){
                if(num2.charAt(i) == '0') continue;
                String temp = Multiply_digit(num1, num2.charAt(i), j);

                Result = Sum(Result, temp);
            }


            return Result;
        }

        private String Sum(String a, String b){
            long carry = 0;
            StringBuilder result = new StringBuilder();
            int i = a.length() - 1, j = b.length() - 1;
            while (i >= 0 && j >= 0){
                long temp = (a.charAt(i--) - '0') + (b.charAt(j--) - '0') + carry;
                result.append(temp%10);
                carry = temp / 10;
            }

            while (i >= 0){
                long temp = (a.charAt(i--) - '0') + carry;
                result.append(temp%10);
                carry = temp / 10;
            }
            while (j >= 0){
                long temp = (b.charAt(j--) - '0') + carry;
                result.append(temp%10);
                carry = temp / 10;
            }

            if(carry != 0) result.append(carry);


            return result.reverse().toString();
        }

        private String Multiply_digit(String num1, char digit, int Zeroes){
            long carry = 0;
            StringBuilder result = new StringBuilder();
            result.append("0".repeat(Math.max(0, Zeroes)));

            int i = num1.length() - 1, number = digit - '0';
            while (i >= 0 ){
                long temp = ((long) (num1.charAt(i--) - '0') * number) + carry;
                result.append((temp%10));
                carry = temp / 10;
            }
            if(carry != 0) result.append(carry);

            return result.reverse().toString();
        }

    }

}
