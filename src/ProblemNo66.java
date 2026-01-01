import java.util.ArrayList;
import java.util.List;

public class ProblemNo66 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] plusOne(int[] digits) {
            if(digits[digits.length-1] != 9){
                digits[digits.length-1]++;
                return digits;
            }

            for(int i = digits.length-1;i>=0;i--){

                if(digits[i]==9){
                    digits[i]=0;

                    if(i==0){
                        int[] digit = new int[digits.length+1];
                        digit[0]=1;
                        return digit;
                    }

                }
                else{
                    digits[i]++;
                    break;
                }
            }

            return digits;
        }
    }

}
