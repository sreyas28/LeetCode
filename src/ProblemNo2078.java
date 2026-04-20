public class ProblemNo2078 {
    public static void main(String[] args) {

    }


    class Solution {
        public int maxDistance(int[] colors) {
            int dis = 0;
            int n = colors.length;
            for (int i = 0; i < n - 1; i++) {
                if (colors[i] != colors[n - 1]) {
                    dis = Math.max(dis, (n - 1) - i);
                    break;
                }
            }

            for (int i = n - 1; i >= 1; i--) {
                if (colors[0] != colors[i]) {
                    dis = Math.max(dis, i);
                }
            }
            return dis;

        }
    }

    // Brute Force
    class Solution_ {
        public int maxDistance(int[] colors) {
            int max = 0;

            for (int i = 0; i < colors.length; i++) {
                int color_1 = colors[i];
                for (int j = 0; j < colors.length; j++) {
                    int color_2 = colors[j];

                    if (color_1 == color_2) continue;
                    max = Math.max(max, Math.abs(i - j));
                }
            }
            return max;
        }
    }

}
