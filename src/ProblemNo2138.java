import java.util.Arrays;
import java.util.Formattable;

public class ProblemNo2138 {

    public static void main(String[] args) {

        ProblemNo2138.Solution a = new ProblemNo2138().new Solution();
        System.out.println(Arrays.toString( a.divideString("abcdefghi", 3, 'x')) );
    }

    class Solution {
        public String[] divideString(String s, int k, char fill) {
            int sLength = s.length(), length = Math.ceilDiv(sLength, k);
            String[] result = new String[length];

            int add_filler = k - (sLength%k);
            s += stringMaker(add_filler, fill);

            for(int i = 0 , j = 0; i < sLength; i += k){
                result[j++] = s.substring(i, i+k);
            }



            return result;
        }

        private String stringMaker(int length, char filler){
            if (length == 0) return "";

            char[] chars = new char[length];
            Arrays.fill(chars, filler);
            return new String(chars);
        }
    }


}
