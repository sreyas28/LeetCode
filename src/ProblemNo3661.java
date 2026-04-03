import java.util.*;

public class ProblemNo3661 {
    public static void main(String[] args) {

        ProblemNo3661.Solution p = new ProblemNo3661().new Solution();
        System.out.println(p.maxWalls(
                new int[]{3, 4, 8, 9, 10, 11, 12, 13, 14, 15, 17, 23, 26, 30, 32, 34, 36, 37, 39, 40, 42, 43, 44, 45, 53, 55, 56, 57, 58, 60, 61, 63, 66, 69, 70, 72, 73, 74},
                new int[]{8, 7, 4, 8, 9, 5, 2, 4, 5, 2, 6, 9, 5, 9, 5, 3, 7, 6, 9, 2, 8, 7, 4, 3, 5, 1, 7, 5, 1, 3, 5, 3, 5, 4, 8, 7, 6, 4},
                new int[]{6, 9, 20, 21, 22, 23, 26, 28, 30, 41, 50, 52, 58, 60, 75}));

        System.out.println(p.maxWalls(new int[]{10, 2}, new int[]{5, 1}, new int[]{1, 5, 2, 7}));


    }

    class Solution {

        private Integer[][] DP;

        public int maxWalls(int[] robots, int[] distance, int[] walls) {
            List<int[]> robotDistances = robotSort(robots, distance);
            Arrays.sort(walls);

            DP = new Integer[robots.length + 1][2];

            return recursion(0, robotDistances, walls, false);
        }

        private int recursion(int i, List<int[]> robotDistances, int[] walls, boolean rightMoved) {
            int rightMovedINT = rightMoved ? 1 : 0;

            if (DP[i][rightMovedINT] != null) return DP[i][rightMovedINT];

            int wallsLeftSide = wallsInRange(walls, robotDistances.get(i)[1], robotDistances.get(i)[0]);
            if (rightMoved)
                wallsLeftSide = wallsInRange(walls, Math.max(robotDistances.get(i - 1)[2] + 1, robotDistances.get(i)[1]), robotDistances.get(i)[0]);

            int wallsRightSide = wallsInRange(walls, robotDistances.get(i)[0], robotDistances.get(i)[2]);

            int recursionL = 0, recursionR = 0;
            if ((i + 1) < robotDistances.size()) {
                recursionL = recursion(i + 1, robotDistances, walls, false);
                recursionR = recursion(i + 1, robotDistances, walls, true);
            }

            int leftSum = wallsLeftSide + recursionL;
            int rightSum = wallsRightSide + recursionR;

            DP[i][rightMovedINT] = Math.max(leftSum, rightSum);
            return Math.max(leftSum, rightSum);
        }

        private List<int[]> robotSort(int[] robots, int[] distance) {
            List<int[]> result = new ArrayList<>();

            for (int i = 0; i < robots.length; i++) {
                int dis = distance[i];
                int rob = robots[i];
                result.add(new int[]{rob, rob - dis, rob + dis});
            }
            result.sort((a, b) -> a[0] - b[0]);


            for (int i = 0; i < result.size(); i++) {
                if (i >= 1)
                    result.get(i)[1] = Math.max(result.get(i)[1], result.get(i - 1)[0] + 1);

                if (i < result.size() - 1)
                    result.get(i)[2] = Math.min(result.get(i)[2], result.get(i + 1)[0] - 1);
            }

            return result;
        }

        private int wallsInRange(int[] walls, int min, int max) {
            int left = 0, right = walls.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (walls[mid] < min) left = mid + 1;
                else right = mid;
            }

            int lowerBound = left;

            left = 0;
            right = walls.length;
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (walls[mid] <= max) left = mid + 1;
                else right = mid;
            }
            int upperBound = left;

            return upperBound - lowerBound;
        }
    }

}
