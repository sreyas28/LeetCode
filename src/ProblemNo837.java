import java.util.Arrays;

public class ProblemNo837 {
    public static void main(String[] args) {

        ProblemNo837.Solution a = new ProblemNo837().new Solution();
        System.out.println(a.new21Game(11, 10, 10));

    }

    class Solution {

        public double new21Game(int n, int k, int maxPts) {
            double[] probabilities = new double[n+1];
            probabilities[0] = 1;

            double ProbSum = k > 0 ? 1:0;
            for(int i = 1 ; i <= n; i++ ){
                probabilities[i] = ProbSum / maxPts;
                if(i < k) ProbSum += probabilities[i];
                if(i - maxPts >= 0 && i - maxPts < k)ProbSum -= probabilities[i-maxPts];
            }

            double result = 0;
            for(int i = k; i <= n; i++) result += probabilities[i];

            return result;
        }
    }

}
