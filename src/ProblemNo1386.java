import java.util.*;

public class ProblemNo1386 {
    public static void main(String[] args) {
        Solution a = new ProblemNo1386().new Solution();
        System.out.println(a.maxNumberOfFamilies(3, new int[][]{{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}}));
        System.out.println(a.maxNumberOfFamilies(4, new int[][]{{4,3},{1,4},{4,6},{1,7}}));
        System.out.println(a.maxNumberOfFamilies(2, new int[][]{{2,1},{1,8},{2,6}}));
    }

    class Solution {
        public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
            Arrays.sort(reservedSeats, (a, b) -> Integer.compare(a[0], b[0]));
            int prev = 0, curRow = 1;

            int count = 0;
            boolean[] group = new boolean[3];
            Arrays.fill(group, true);

            for (int[] cur : reservedSeats) {
                int row = cur[0], col = cur[1];
                if (row != curRow) {
                    prev = curRow;
                    curRow = row;

                    if ((group[0] && group[1] && group[2]) || (group[0] && group[2])) count += 2;
                    else if ((group[0] && group[1]) || (group[1] && group[2])) count += 1;
                    else if (group[0] || group[1] || group[2]) count += 1;

                    count += (curRow - prev - 1) * 2;
                    Arrays.fill(group, true);
                }

                if (col >= 2 && col <= 9) {
                    switch (col) {
                        case 2, 3:
                            group[0] = false;
                            break;
                        case 4, 5:
                            group[0] = false;
                            group[1] = false;
                            break;
                        case 6, 7:
                            group[1] = false;
                            group[2] = false;
                            break;
                        case 8, 9:
                            group[2] = false;
                            break;
                    }
                }
            }

            prev = curRow;
            curRow = n + 1;
            if ((group[0] && group[1] && group[2]) || (group[0] && group[2])) count += 2;
            else if ((group[0] && group[1]) || (group[1] && group[2])) count += 1;
            else if (group[0] || group[1] || group[2]) count += 1;

            count += (curRow - prev - 1) * 2;
            return count;
        }
    }
}
