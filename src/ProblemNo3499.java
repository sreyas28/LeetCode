public class ProblemNo3499 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3499().new Solution();
        System.out.println(a.maxActiveSectionsAfterTrade("0101101110")); // 8
        System.out.println(a.maxActiveSectionsAfterTrade("0111011010")); // 8
        System.out.println(a.maxActiveSectionsAfterTrade("01101001")); // 7
        System.out.println(a.maxActiveSectionsAfterTrade("01101")); // 5
        System.out.println(a.maxActiveSectionsAfterTrade("01")); // 1
        System.out.println(a.maxActiveSectionsAfterTrade("10")); // 1

    }

    class Solution {
        public int maxActiveSectionsAfterTrade(String s) {
            int ones = 0, leftZero = 0, rightZero = 0, maxZeroLen = 0, inBetweenOnes = 0;

            for(char c : s.toCharArray()) {
                if (c == '0') {
                    if (inBetweenOnes == 0) leftZero++; // and rightZero == 0
                    else rightZero++; // for leftZero !=0 and inBetweenOne != 0
                }

                else if (c == '1'){
                    ones++;

                    if (leftZero != 0 && rightZero == 0) inBetweenOnes++; // leftZero != 0 and rightZero == 0
                    else if (inBetweenOnes != 0) { // leftZero != 0 && inBetweenOnes != 0 && rightZero != 0
                        int tempZeroLen = leftZero + rightZero;

                        maxZeroLen = Math.max(maxZeroLen, tempZeroLen);

                        leftZero = rightZero;
                        rightZero = 0;
                        inBetweenOnes = 1;
                    }
                }
            }

            if (rightZero != 0) {
                int tempZeroLen = leftZero + rightZero;
                maxZeroLen = Math.max(maxZeroLen, tempZeroLen);
            }


            return ones + maxZeroLen;
        }
    }

    // someWhat a Solution
    class Solution_ {
        public int maxActiveSectionsAfterTrade(String s) {
            int inBetweenOnes = 0, leftZero = 0, rightZero = 0, lastOne = 0, max010 = 0, result = 0;

            for(char c : s.toCharArray()) {
                if (c == '0'){
                    if (inBetweenOnes == 0) leftZero++; // and rightZero == 0
                    else rightZero++; // for leftZero !=0 and inBetweenOne != 0
                }
                else if (c == '1'){
                    if (leftZero == 0) result++;
                    else if (rightZero == 0) inBetweenOnes++; // leftZero != 0 and rightZero == 0
                    else { // leftZero != 0 && inBetweenOnes != 0 && rightZero != 0
                        int temp010 = inBetweenOnes + leftZero + rightZero;

                        if (temp010 > max010) {
                            max010 = temp010;
                            result += lastOne;

                            lastOne = inBetweenOnes;
                        }
                        else {
                            result += inBetweenOnes;
                        }

                        leftZero = rightZero;
                        rightZero = 0;
                        inBetweenOnes = 1;
                    }
                }
            }

            int temp010 = inBetweenOnes + leftZero + rightZero;
            if (temp010 > max010 && rightZero != 0) {
                max010 = temp010;
                result += lastOne + max010;
            }
            else result += inBetweenOnes + max010;

            return result;
        }
    }

}
