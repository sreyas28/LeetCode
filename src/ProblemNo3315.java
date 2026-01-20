import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemNo3315 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(11);

        ProblemNo3314.Solution p = new ProblemNo3314().new Solution();
        System.out.println(Arrays.toString(p.minBitwiseArray(list)));
    }

    class Solution {
        public int[] minBitwiseArray(List<Integer> nums) {
            int[] res = new int[nums.size()];

            for (int i = 0; i < nums.size(); i++) {
                System.out.print( nums.get(i) + ": "+ Integer.toBinaryString(nums.get(i)) + ": ");
                res[i] = resultant(nums.get(i));
            }

            return res;
        }

        private int resultant(int number) {
            if(number == 2) return -1;

            String bits = Integer.toBinaryString(number);
            StringBuilder newNumber = new StringBuilder();

            boolean firstZero = false;
            for (int i = bits.length() - 1; i >= 0; i--) {
                char bit = bits.charAt(i);

                if(bit == '1') newNumber.insert(0, '1');
                else{
                    firstZero = true;
                    newNumber.replace(0,1, "0");
                    newNumber.insert(0,bits.substring(0,i+1));
                    break;
                }
            }

            if(!firstZero) newNumber.replace(0,1, "0");
            System.out.println(newNumber.toString());

            return decimalConversion(newNumber.toString());
        }

        private int decimalConversion(String binary) {
            int res = 0;
            for (int i = binary.length() - 1; i >= 0; i--) {
                if(binary.charAt(i) == '1') {
                    res += (int) Math.pow(2, binary.length() - i -1);
                }
            }

            return res;
        }
    }

}
