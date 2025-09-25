import java.util.List;

public class ProblemNo120 {

    public static void main(String[] args) {

    }

    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {

            for(int i=triangle.size() - 2; i >= 0; i--){

                for(int j=0; j < triangle.get(i).size(); j++){

                    int below = triangle.get(i+1).get(j);
                    int belowRight = triangle.get(i+1).get(j+1);

                    int current = triangle.get(i).get(j);

                    triangle.get(i).set(j, Math.min(below, belowRight) + current);
                }

            }

            return triangle.getFirst().getFirst();
        }
    }
}
