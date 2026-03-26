import java.util.*;

public class ProblemNo3548 {
    public static void main(String[] args) {
        ProblemNo3548.Solution problem = new ProblemNo3548().new Solution();
        System.out.println(problem.canPartitionGrid(new int[][]{{100000}, {86218}, {100000}}));
        System.out.println(problem.canPartitionGrid(new int[][]{{73816}, {71688}}));
    }

    // Very Cool Solution By LeetCode 🤓
    class Solution {
        public boolean canPartitionGrid(int[][] grid) {
            long total = 0;
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    total += grid[i][j];
                }
            }
            for (int k = 0; k < 4; k++) {
                Set<Long> exist = new HashSet<>();
                exist.add(0L);
                long sum = 0;
                m = grid.length;
                n = grid[0].length;
                if (m < 2) {
                    grid = rotation(grid);
                    continue;
                }
                if (n == 1) {
                    for (int i = 0; i < m - 1; i++) {
                        sum += grid[i][0];
                        long tag = sum * 2 - total;
                        if (tag == 0 || tag == grid[0][0] || tag == grid[i][0]) return true;
                    }
                    grid = rotation(grid);
                    continue;
                }
                for (int i = 0; i < m - 1; i++) {
                    for (int j = 0; j < n; j++) {
                        exist.add((long) grid[i][j]);
                        sum += grid[i][j];
                    }
                    long tag = sum * 2 - total;
                    if (i == 0) {
                        if (tag == 0 || tag == grid[0][0] || tag == grid[0][n - 1]) return true;
                        continue;
                    }
                    if (exist.contains(tag)) return true;
                }
                grid = rotation(grid);
            }
            return false;
        }

        public int[][] rotation(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] tmp = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    tmp[j][m - 1 - i] = grid[i][j];
                }
            }
            return tmp;
        }
    }

    // TLE 😭😭😭
    class Solution__ {
        public boolean canPartitionGrid(int[][] grid) {
            final int rows = grid.length, cols = grid[0].length;
            long[] rowsPrefixSum = new long[rows];
            long[] colsPrefixSum = new long[cols];

            List<Set<Integer>> rowsWise = new ArrayList<>();
            List<Set<Integer>> colsWise = new ArrayList<>();

            for (int i = 0; i < cols; i++) colsWise.add(new HashSet<>());

            long sum = 0;
            for (int i = 0; i < rows; i++) {
                Set<Integer> rowsSet = new HashSet<>();

                for (int j = 0; j < cols; j++) {
                    int currentValue = grid[i][j];

                    sum += currentValue;
                    rowsPrefixSum[i] += currentValue;
                    colsPrefixSum[j] += currentValue;

                    rowsSet.add(currentValue);
                    colsWise.get(j).add(currentValue);
                }
                rowsWise.add(rowsSet);
            }

            for (int i = 1; i < rows; i++) rowsPrefixSum[i] += rowsPrefixSum[i - 1];
            for (int i = 1; i < cols; i++) colsPrefixSum[i] += colsPrefixSum[i - 1];

            if (rows == 1 || cols == 1) return specialCases(rows, cols, sum, rowsPrefixSum, colsPrefixSum, grid);

            // horizontal cuts
            Set<Integer> upperVals = new HashSet<>();
            upperVals.add(grid[0][0]);
            upperVals.add(grid[0][cols - 1]);

            for (int i = 1; i < rows; i++) {
                long upperSum = rowsPrefixSum[i - 1];
                long lowerSum = sum - upperSum;

                if (upperSum == lowerSum) return true;
                else if (upperSum > lowerSum) {
                    int theVal = (int) (upperSum - lowerSum);
                    if (upperVals.contains(theVal)) return true;
                } else {
                    int theVal = (int) (lowerSum - upperSum);

                    if (i != rows - 1) {
                        for (Set<Integer> set : rowsWise) {
                            if (set.contains(theVal)) return true;
                        }
                    } else if (grid[i][0] == theVal || grid[i][cols - 1] == theVal) return true;
                }

                upperVals.addAll(rowsWise.getFirst());
                rowsWise.removeFirst();
            }

            // vertical cuts
            Set<Integer> leftVals = new HashSet<>();
            leftVals.add(grid[0][0]);
            leftVals.add(grid[rows - 1][0]);

            for (int i = 1; i < cols; i++) {
                long leftSum = colsPrefixSum[i - 1];
                long rightSum = sum - leftSum;

                if (leftSum == rightSum) return true;
                else if (leftSum > rightSum) {
                    int theVal = (int) (leftSum - rightSum);
                    if (leftVals.contains(theVal)) return true;
                } else {
                    int theVal = (int) (rightSum - leftSum);
                    if (i != cols - 1) {
                        for (Set<Integer> set : colsWise) {
                            if (set.contains(theVal)) return true;
                        }
                    } else if (grid[0][i] == theVal || grid[rows - 1][i] == theVal) return true;
                }

                leftVals.addAll(colsWise.getFirst());
                colsWise.removeFirst();
            }


            return false;
        }

        private boolean specialCases(
                int rows,
                int cols,
                long sum,
                long[] rowsPrefixSum,
                long[] colsPrefixSum,
                int[][] grid
        ) {

            if (rows == 1 && cols == 2) return grid[0][0] == grid[0][1];
            else if (rows == 2 && cols == 1) return grid[0][0] == grid[1][0];
            else if (rows == 1) {
                for (int i = 1; i < cols; i++) {
                    long leftSum = colsPrefixSum[i - 1];
                    long rightSum = sum - leftSum;

                    if (leftSum == rightSum) return true;

                    else if (leftSum > rightSum) {
                        int theVal = (int) (leftSum - rightSum);
                        if (theVal == grid[0][0] || theVal == grid[0][i - 1]) return true;
                    } else {
                        int theVal = (int) (rightSum - leftSum);
                        if (theVal == grid[0][cols - 1] || theVal == grid[0][i]) return true;
                    }
                }
            } else if (cols == 1) {
                for (int i = 1; i < rows; i++) {
                    long topSum = rowsPrefixSum[i - 1];
                    long bottomSum = sum - topSum;

                    if (topSum == bottomSum) return true;

                    else if (topSum > bottomSum) {
                        int theVal = (int) (topSum - bottomSum);
                        if (theVal == grid[0][0] || theVal == grid[i - 1][0]) return true;
                    } else {
                        int theVal = (int) (bottomSum - topSum);
                        if (theVal == grid[rows - 1][0] || theVal == grid[i][0]) return true;
                    }
                }
            }

            return false;
        }
    }

    // Don't See BrainF*ck
    class Solution_ {
        public boolean canPartitionGrid(int[][] grid) {
            final int rows = grid.length, cols = grid[0].length;
            long[] rowsPrefixSum = new long[rows];
            long[] colsPrefixSum = new long[cols];

            List<Integer> top = new ArrayList<>();
            List<Integer> bottom = new ArrayList<>();

            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();

            long sum = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int currentValue = grid[i][j];

                    sum += currentValue;
                    rowsPrefixSum[i] += currentValue;
                    colsPrefixSum[j] += currentValue;

                    if (i == 0) top.add(currentValue);
                    if (i == rows - 1) bottom.add(currentValue);
                }

                left.add(grid[i][0]);
                right.add(grid[i][cols - 1]);
            }

            for (int i = 1; i < rows; i++) rowsPrefixSum[i] += rowsPrefixSum[i - 1];
            for (int i = 1; i < cols; i++) colsPrefixSum[i] += colsPrefixSum[i - 1];

            if (rows == 1 || cols == 1) return specialCases(rows, cols, sum, rowsPrefixSum, colsPrefixSum, grid);

            // prefix sum in bot order
            if (horizontal(grid, left, right, top, bottom, rows, cols, rowsPrefixSum, sum)) return true;

            // only for Vertical
            return vertical(grid, left, right, top, bottom, rows, cols, colsPrefixSum, sum);
        }

        private boolean horizontal(
                int[][] grid,
                List<Integer> left,
                List<Integer> right,
                List<Integer> top,
                List<Integer> bottom,
                int rows,
                int cols,
                long[] rowsPrefixSum,
                long sum
        ) {
            List<Integer> localLeftRight_Upper = new ArrayList<>();

            List<Integer> localLeft_Lower = new ArrayList<>(left);
            List<Integer> localRight_Lower = new ArrayList<>(right);

            List<Integer> midUpper = new ArrayList<>();
            List<Integer> midLower = new ArrayList<>();

            // only for Horizontal
            for (int i = 1; i < rows; i++) {
                localLeftRight_Upper.add(grid[i - 1][0]);
                localLeftRight_Upper.add(grid[i - 1][cols - 1]);

                localLeft_Lower.removeFirst();
                localRight_Lower.removeFirst();

                long sumUpper = rowsPrefixSum[i - 1];
                long sumLower = sum - sumUpper;

                if (sumUpper == sumLower) return true;

                if (i == 1) {
                    if (sumUpper > sumLower) {
                        int theVal = (int) (sumUpper - sumLower);
                        if (localLeftRight_Upper.contains(theVal)) return true;
                    } else {
                        int theVal = (int) (sumLower - sumUpper);
                        if (localLeft_Lower.contains(theVal) || localRight_Lower.contains(theVal)) return true;
                            // special case for row == 2
                        else if (rows == 2) continue;
                        else if (bottom.contains(theVal)) return true;
                        else {
                            for (int col = 1; col < cols - 1; col++) midLower.add(grid[i][col]);
                            if (midLower.contains(theVal)) return true;
                        }
                    }
                } else if (i == rows - 1) {
                    if (sumUpper < sumLower) {
                        int theVal = (int) (sumLower - sumUpper);
                        if (localLeft_Lower.contains(theVal) || localRight_Lower.contains(theVal)) return true;
                    } else {
                        int theVal = (int) (sumUpper - sumLower);
                        if (localLeftRight_Upper.contains(theVal) || top.contains(theVal) || midUpper.contains(theVal))
                            return true;
                    }
                } else {
                    if (sumUpper > sumLower) {
                        int theVal = (int) (sumUpper - sumLower);
                        if (localLeftRight_Upper.contains(theVal) || top.contains(theVal) || midUpper.contains(theVal))
                            return true;
                    } else {
                        int theVal = (int) (sumLower - sumUpper);
                        if (localLeft_Lower.contains(theVal) || localRight_Lower.contains(theVal) || bottom.contains(theVal))
                            return true;
                        else {
                            midUpper = new ArrayList<>(midLower);
                            midLower = new ArrayList<>();
                            for (int col = 1; col < cols - 1; col++) midLower.add(grid[i][col]);
                            if (midLower.contains(theVal)) return true;
                        }
                    }
                }
            }

            return false;
        }

        private boolean vertical(
                int[][] grid,
                List<Integer> left,
                List<Integer> right,
                List<Integer> top,
                List<Integer> bottom,
                int rows,
                int cols,
                long[] colsPrefixSum,
                long sum
        ) {
            List<Integer> localTopBottom_Right = new ArrayList<>();

            List<Integer> localTop_Right = new ArrayList<>(top);
            List<Integer> localBottom_Right = new ArrayList<>(bottom);

            List<Integer> midLeft = new ArrayList<>();
            List<Integer> midRight = new ArrayList<>();

            // only for Vertical
            for (int i = 1; i < cols; i++) {
                localTopBottom_Right.add(grid[0][i - 1]);
                localTopBottom_Right.add(grid[rows - 1][i - 1]);

                localTop_Right.removeFirst();
                localBottom_Right.removeFirst();

                long sumLeft = colsPrefixSum[i - 1];
                long sumRight = sum - sumLeft;

                if (sumLeft == sumRight) return true;

                if (i == 1) {
                    if (sumLeft > sumRight) {
                        int theVal = (int) (sumLeft - sumRight);
                        if (localTopBottom_Right.contains(theVal)) return true;
                    } else {
                        int theVal = (int) (sumRight - sumLeft);
                        if (localTop_Right.contains(theVal) || localBottom_Right.contains(theVal)) return true;
                            // special case for col == 2
                        else if (cols == 2) continue;
                        else if (right.contains(theVal)) return true;
                        else {
                            for (int row = 1; row < rows - 1; row++) midRight.add(grid[row][i]);
                            if (midRight.contains(theVal)) return true;
                        }
                    }
                } else if (i == cols - 1) {
                    if (sumLeft < sumRight) {
                        int theVal = (int) (sumRight - sumLeft);
                        if (localTop_Right.contains(theVal) || localBottom_Right.contains(theVal)) return true;
                    } else {
                        int theVal = (int) (sumLeft - sumRight);
                        if (localTopBottom_Right.contains(theVal) || left.contains(theVal) || midLeft.contains(theVal))
                            return true;
                    }
                } else {
                    if (sumLeft > sumRight) {
                        int theVal = (int) (sumLeft - sumRight);
                        if (localTopBottom_Right.contains(theVal) || left.contains(theVal) || midLeft.contains(theVal))
                            return true;
                    } else {
                        int theVal = (int) (sumRight - sumLeft);
                        if (localTop_Right.contains(theVal) || localBottom_Right.contains(theVal) || right.contains(theVal))
                            return true;
                        else {
                            midLeft = new ArrayList<>(midRight);
                            midRight = new ArrayList<>();
                            for (int row = 1; row < rows - 1; row++) midRight.add(grid[row][i]);
                            if (midRight.contains(theVal)) return true;
                        }
                    }
                }
            }

            return false;
        }

        private boolean specialCases(
                int rows,
                int cols,
                long sum,
                long[] rowsPrefixSum,
                long[] colsPrefixSum,
                int[][] grid
        ) {

            if (rows == 1 && cols == 2) return grid[0][0] == grid[0][1];
            else if (rows == 2 && cols == 1) return grid[0][0] == grid[1][0];
            else if (rows == 1) {
                for (int i = 1; i < cols; i++) {
                    long leftSum = colsPrefixSum[i - 1];
                    long rightSum = sum - leftSum;

                    if (leftSum == rightSum) return true;

                    else if (leftSum > rightSum) {
                        int theVal = (int) (leftSum - rightSum);
                        if (theVal == grid[0][0] || theVal == grid[0][i - 1]) return true;
                    } else {
                        int theVal = (int) (rightSum - leftSum);
                        if (theVal == grid[0][cols - 1] || theVal == grid[0][i]) return true;
                    }
                }
            } else if (cols == 1) {
                for (int i = 1; i < rows; i++) {
                    long topSum = rowsPrefixSum[i - 1];
                    long bottomSum = sum - topSum;

                    if (topSum == bottomSum) return true;

                    else if (topSum > bottomSum) {
                        int theVal = (int) (topSum - bottomSum);
                        if (theVal == grid[0][0] || theVal == grid[i - 1][0]) return true;
                    } else {
                        int theVal = (int) (bottomSum - topSum);
                        if (theVal == grid[rows - 1][0] || theVal == grid[i][0]) return true;
                    }
                }
            }

            return false;
        }
    }

}
