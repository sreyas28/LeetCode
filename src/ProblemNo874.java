import java.util.*;

public class ProblemNo874 {
    public static void main(String[] args) {

        ProblemNo874.Solution a = new ProblemNo874().new Solution();
        System.out.println(a.robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));

    }

    class Solution {

        private final long HASH_MULTIPLIER = 60011;

        public int robotSim(int[] commands, int[][] obstacles) {

            Set<Long> blocksHash = new HashSet<>();
            for (int[] block : obstacles) blocksHash.add(getHash(block[0], block[1]));

            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int dir = 0;

            int dx = 0, dy = 0;
            int maxDist = 0;

            for (int command : commands) {
                if (command == -1) dir = (dir + 1) % 4;
                else if (command == -2) dir = (dir + 3) % 4;
                else {
                    int[] currentDir = directions[dir];

                    for (int step = 0; step < command; step++) {
                        int new_dx = dx + currentDir[0];
                        int new_dy = dy + currentDir[1];

                        long hash = getHash(new_dx, new_dy);
                        if (blocksHash.contains(hash)) break;

                        dx = new_dx;
                        dy = new_dy;
                    }

                    maxDist = Math.max(maxDist, euclideanDistance(dx, dy));
                }
            }


            return maxDist;
        }

        private int euclideanDistance(int x, int y) {
            return (x * x) + (y * y);
        }

        private long getHash(int x, int y) {
            return x + y * HASH_MULTIPLIER;
        }

    }

}
