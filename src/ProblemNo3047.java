import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemNo3047 {
    public static void main(String[] args) {

        ProblemNo3047.Solution a = new ProblemNo3047().new Solution();
        System.out.println(a.largestSquareArea(new int[][]{{2, 2}, {1, 3}}, new int[][]{{3, 4}, {5, 5}}));

    }

    class Solution {
        public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
            List<int[][]> points = new ArrayList<>();
            int len = bottomLeft.length;

            for (int i = 0; i < len; i++) {
                points.add(new int[][]{bottomLeft[i], topRight[i]});
            }

            points.sort((int[][] a, int[][] b) -> {
                if (a[0][0] == b[0][0]) {
                    if (a[0][1] == b[0][1]) {
                        if (a[1][0] == b[1][0]) {
                            return a[1][1] - b[1][1];
                        }
                        return a[1][0] - b[1][0];
                    }
                    return a[0][1] - b[0][1];
                }
                return a[0][0] - b[0][0];
            });

            for (int[][] i : points) {
                System.out.println(Arrays.deepToString(i));
            }

            long answer = 0;
            // 0 is bottom and 1 is top
            for (int i = 1; i < len; i++) {
                int[][] cur = points.get(i);

                for (int j = 0; j < i; j++) {
                    int[][] point = points.get(j);

                    int overlapLeft = Math.max(point[0][0], cur[0][0]);
                    int overlapBottom = Math.max(point[0][1], cur[0][1]);
                    int overlapRight = Math.min(point[1][0], cur[1][0]);
                    int overlapTop = Math.min(point[1][1], cur[1][1]);

                    int width = overlapRight - overlapLeft;
                    int height = overlapTop - overlapBottom;
                    if (width > 0 && height > 0) {
                        int side = Math.min(width, height);
                        answer = Math.max(answer, (long) side * side);
                    }

                }
            }

            return answer;
        }
    }

}
