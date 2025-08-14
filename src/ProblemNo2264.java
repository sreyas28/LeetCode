public class ProblemNo2264 {

    public static void main(String[] args) {

    }

    class Solution {
        public String largestGoodInteger(String num) {
            String result = "-1";

            for(int i = 1; i < num.length() -1 ; i++){
                if(num.charAt(i) == num.charAt(i-1) && num.charAt(i) == num.charAt(i+1)){
                    String tempResult = num.substring(i-1, i+2);

                    if(Integer.parseInt(tempResult) > Integer.parseInt(result)){
                        result = tempResult;
                    }
                }
            }

            return result.equals("-1") ? "" : result;
        }
    }

}
