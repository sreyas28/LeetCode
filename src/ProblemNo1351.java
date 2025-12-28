public class ProblemNo1351 {
    public static void main(String[] args) {
        ProblemNo1351.Solution p = new ProblemNo1351().new Solution();
        System.out.println(p.countNegatives(new int[][] { {7,-3}}));
    }

    class Solution {
        public int countNegatives(int[][] grid) {
            int len = grid[0].length;
            int count = 0;

            for(int row=0; row<grid.length; row++){
                int left = 0;
                int right = len-1;

                while(left < right){
                    int mid = (left+right)/2;

                    if(grid[row][mid]<0) right = mid;
                    else left = mid+1;
                }

                if(grid[row][left] < 0) count +=  len - left;
            }

            return count;
        }
    }

}
