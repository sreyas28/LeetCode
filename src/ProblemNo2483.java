public class ProblemNo2483 {
    public static void main(String[] args) {
        ProblemNo2483.Solution p = new ProblemNo2483().new Solution();
        System.out.println(p.bestClosingTime("YYNY"));

    }

    class Solution {
        public int bestClosingTime(String customers) {
            int suffixSumY = 0;
            int prefixSumN = 0;

            for(char ch : customers.toCharArray()) {
                if(ch == 'Y') suffixSumY++;
            }

            int minPenalty = suffixSumY;
            int minIndex = 0;

            for(int j = 0; j < customers.length(); j++) {
                char ch = customers.charAt(j);

                if(ch == 'Y') suffixSumY--;
                else if(ch == 'N') prefixSumN++;

                if(minPenalty > prefixSumN+suffixSumY) {
                    minPenalty = prefixSumN+suffixSumY;
                    minIndex = j+1;
                }
            }

            return minIndex;
        }
    }

}
