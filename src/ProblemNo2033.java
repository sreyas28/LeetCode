import java.util.Arrays;

public class ProblemNo2033 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minOperations(int[][] grid, int x) {
            int[] flatten = new int[grid.length*grid[0].length];

            int k = 0;
            for (int[] a: grid) {
                for (int b: a) {
                    flatten[k++] = b;
                }
            }

            Arrays.sort(flatten);
            int median = flatten[flatten.length/2];

            int change = 0;
            for(int i: flatten){
                if ( Math.abs(i - median) % x != 0 ) return -1;
                else change +=  Math.abs(i - median) / x;
            }

            return change;
        }
    }

}
