public class ProblemNo868 {
    public static void main(String[] args) {

    }

    class Solution {
        public int binaryGap(int n) {
            int maxGap = 0;

            int currentGap = 0;
            while (n != 0) {
                if((n&1) == 1){
                    if(currentGap != 0){
                        maxGap = Math.max(maxGap, currentGap);
                        currentGap = 1;
                    }
                    else currentGap = 1;
                }
                else if (currentGap != 0) currentGap += 1;

                n = n >>> 1;
            }

            return maxGap;
        }
    }

}
