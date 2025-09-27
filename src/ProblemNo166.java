import java.util.HashMap;
import java.util.Map;

public class ProblemNo166 {
    public static void main(String[] args) {

        ProblemNo166.Solution a = new ProblemNo166().new Solution();
        System.out.println(a.fractionToDecimal(-1,-2147483648));

    }

    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if(numerator == 0) return "0";

            StringBuilder result = new StringBuilder();
            Map<Long, Integer> remIndex = new HashMap<>();

            if ((numerator < 0) ^ (denominator < 0)) result.append("-");

            long num = Math.abs((long) numerator);
            long den = Math.abs((long) denominator);

            result.append(num/den);
            num %= den;

            if(num == 0) return result.toString();

            result.append(".");
            while(num !=0){
                if (remIndex.containsKey(num)) {
                    int index = remIndex.get(num);
                    result.insert(index, "(");
                    result.append(")");
                    break;
                }

                remIndex.put(num, result.length());
                num *= 10;
                result.append(num/den);
                num %= den;

            }

            return result.toString();
        }
    }

}
