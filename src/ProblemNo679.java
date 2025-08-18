import java.util.ArrayList;
import java.util.List;

public class ProblemNo679 {

    public static void main(String[] args) {

        ProblemNo679.Solution a = new ProblemNo679().new Solution();
        System.out.println(a.judgePoint24(new int[]{8,1,4,7}));

    }

    class Solution {

        public boolean judgePoint24(int[] cards) {
            List<Double> values = new ArrayList<>();
            for (int i: cards) values.add((double) i);

            return backtracking(values);
        }

        private boolean backtracking(List<Double> values){
            if (values.size() == 1) return Math.abs(values.getFirst() - 24.0) < 1e-6;

            for(int card_a = 0; card_a < values.size(); card_a++){
                for (int card_b = card_a + 1; card_b < values.size(); card_b++){

                    List<Double> next = new ArrayList<>();
                    for(int n = 0; n < values.size(); n ++){
                        if(n != card_a && n != card_b) next.add(values.get(n));
                    }

                    for(double operations: helper(values.get(card_a), values.get(card_b) )){
                        next.add(operations);
                        if(backtracking(next)) return true;
                        next.removeLast();
                    }
                }
            }
            return false;
        }

        private double[] helper(double a, double b){

            return new double[]{a+b, a-b, b-a, a*b, a/b, b/a};
        }
    }

}
