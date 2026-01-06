import java.util.Arrays;

public class ProblemNo537 {
    public static void main(String[] args) {

        ProblemNo537.Solution a = new ProblemNo537().new Solution();
        System.out.println(a.complexNumberMultiply("-1456+1i", "1+-1i"));

    }

    class Solution {
        public String complexNumberMultiply(String num1, String num2) {
            int[] num1Arr = stringToArray(num1);
            int[] num2Arr = stringToArray(num2);

            int[] result = new int[2];

            result[0] = (num1Arr[0] * num2Arr[0]) + (num1Arr[1] * num2Arr[1]) * -1;
            result[1] = (num1Arr[0] * num2Arr[1]) + (num1Arr[1] * num2Arr[0]);

            return result[0] + "+" + result[1] + "i";
        }

        private int[] stringToArray(String num){
            int[] result = new int[2];

            for(int i=0; i<num.length(); i++){
                if(num.charAt(i)=='+'){
                    String real = num.substring(0, i);
                    String imag = num.substring(i+1, num.length()-1);
                    result[0] = real.charAt(0) == '-' ? Integer.parseInt(real.substring(1)) * -1: Integer.parseInt(real);
                    result[1] = imag.charAt(0) == '-' ? Integer.parseInt(imag.substring(1)) * -1: Integer.parseInt(imag);
                    break;
                }
            }

            return result;
        }
    }

}
