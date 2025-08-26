public class ProblemNo3000 {
    public static void main(String[] args) {
        ProblemNo3000.Solution a = new ProblemNo3000().new Solution();
        System.out.println(a.areaOfMaxDiagonal(new int[][]{
                {6,5},{8,6},{2,10},{8,1},{9,2},{3,5},{3,5}
        }));

    }

    class Solution {
        public int areaOfMaxDiagonal(int[][] dimensions) {
            double diagonal = 0;
            int area = 0;

            for(int[] dimension: dimensions){
                double val = Math.sqrt(Math.pow(dimension[0],2) + Math.pow(dimension[1],2));

                if(val > diagonal){
                    diagonal = val;
                    area = dimension[0] * dimension[1];
                }
                else if(val == diagonal) area = Math.max(area, dimension[0] * dimension[1]);
            }

            return area;
        }
    }

}
