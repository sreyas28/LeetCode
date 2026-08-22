public class ProblemNo74 {
    public static void main(String[] args) {

        Solution a = new ProblemNo74().new Solution();
        System.out.println(a.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));

    }

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            final int ROW = matrix.length, COL = matrix[0].length;

            int left = 0, right = ROW * COL - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int r = mid / COL, c = mid % COL;

                if  (matrix[r][c] > target) right = mid - 1;
                else if (matrix[r][c] < target) left = mid + 1;
                else return true;
            }

            return false;
        }
    }

}
