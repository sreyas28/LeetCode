public class ProblemNo3234 {
    public static void main(String[] args) {

        ProblemNo3234.Solution a = new ProblemNo3234().new Solution();
        System.out.println(a.numberOfSubstrings("00011"));

    }

    class Solution {
        public int numberOfSubstrings(String s) {
            int n = s.length(), result = 0;

            int[] oneArray = new int[n];
            oneArray[0] = s.charAt(0) - 48;
            for(int i=1; i<n; i++) oneArray[i] = oneArray[i-1] + (s.charAt(i)-48);

            for(int start = 0; start<n; start++){
                int end = start;
                while(end<n){
                    int ones = oneArray[end] - ( (start-1 >=0) ? oneArray[start-1] : 0);
                    int zeroes = (end - start + 1) - ones;

                    int zeroSQR = zeroes * zeroes;

                    if(zeroSQR == ones) {
                        result++;
                        end++;
                    }
                    else if(zeroSQR > ones) end += zeroSQR - ones;
                    else {
                        int wantMaxZeros = (int) Math.min(Math.max(Math.sqrt(ones) - zeroes, 1), n-end);
                        result += wantMaxZeros;
                        end += wantMaxZeros;
                    }
                }
            }

            return result;
        }
    }

}
