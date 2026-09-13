public class ProblemNo835 {
    public static void main(String[] args) {

    }

    class Solution {
        public int largestOverlap(int[][] img1, int[][] img2) {
            final int n = img1.length, maxTranslation = 1 - n;
            int maxOnes = 0;

            for (int shiftRow = maxTranslation; shiftRow < n; shiftRow++) {
                for (int shiftCol = maxTranslation; shiftCol < n; shiftCol++) {
                    int tempMaxOnes = 0;

                    for (int img1X = 0; img1X < n; img1X++) {
                        int img2X = shiftRow + img1X;

                        if (img2X < 0 || img2X >= n) continue;

                        for (int img1Y = 0; img1Y < n; img1Y++) {
                            int img2Y = shiftCol + img1Y;

                            if (img2Y < 0 || img2Y >= n) continue;
                            if (img1[img1X][img1Y] == 1 && img1[img1X][img1Y] == img2[img2X][img2Y]) tempMaxOnes++;
                        }
                    }

                    maxOnes = Math.max(maxOnes, tempMaxOnes);
                }
            }

            return maxOnes;
        }
    }

}
