import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo3568 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3568().new Solution();
//        System.out.println(a.minMoves(new String[]{"S.", "XL"}, 2));
        System.out.println(a.minMoves(new String[]{"LS", "RL"}, 4));

    }

    class Solution {
        static class Cleaner{
            int x, y, energyLeft, mask, step;
            Cleaner(int x, int y, int energyLeft, int mask, int step) {
                this.x = x;
                this.y = y;
                this.energyLeft = energyLeft;
                this.mask = mask;
                this.step = step;
            }
        }

        private int N, M;
        public int minMoves(String[] classroom, int energy) {
            final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            this.N = classroom.length;
            this.M = classroom[0].length();

            int[] start = new int[2];
            int[][] litterMap = new int[N][M];
            int litterCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (classroom[i].charAt(j) == 'S') {
                        start[0] = i;
                        start[1] = j;
                    }
                    else if (classroom[i].charAt(j) == 'L') {
                        litterMap[i][j] = 1 << litterCount;
                        litterCount++;
                    }
                }
            }
            if (litterCount == 0) return 0;

            int targetMask = (1 << litterCount);
            int[][][] bestEnergy = new int[N][M][targetMask];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) Arrays.fill(bestEnergy[i][j], -1);
            }

            bestEnergy[start[0]][start[1]][0] = energy;

            Queue<Cleaner> queue = new LinkedList<>();
            queue.add(new Cleaner(start[0], start[1], energy, 0, 0));

            while (!queue.isEmpty()) {
                Cleaner current = queue.poll();

                if (current.mask == targetMask-1) return current.step;
                if (current.energyLeft == 0) continue;

                for(int[] dir: DIR){
                    int newX = current.x + dir[0];
                    int newY = current.y + dir[1];

                    if (sanityCheck(newX, newY) && classroom[newX].charAt(newY) != 'X') {
                        int newEnergy = classroom[newX].charAt(newY) == 'R' ? energy: current.energyLeft - 1;
                        int newMask = current.mask | litterMap[newX][newY];

                        if (newEnergy > bestEnergy[newX][newY][newMask]){
                            bestEnergy[newX][newY][newMask] = newEnergy;
                            queue.add(new Cleaner(newX, newY, newEnergy, newMask, current.step + 1));
                        }
                    }
                }
            }

            return -1;
        }

        private boolean sanityCheck(int i, int j) {
            return i >= 0 && i < N && j >= 0 && j < M;
        }

    }

}
