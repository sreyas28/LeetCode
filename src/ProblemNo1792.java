import java.util.Arrays;
import java.util.PriorityQueue;

public class ProblemNo1792 {
    public static void main(String[] args) {

        ProblemNo1792.Solution a = new ProblemNo1792().new Solution();
        System.out.println(a.maxAverageRatio(new int[][]{
                {2,4},{3,9},{4,5},{2,10}
        }, 4));

    }

    class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<double[]> heap = new PriorityQueue<>((a,b) -> {
                double val_1 = ((a[0]+1) / (a[1]+1)) - (a[0] / a[1]);
                double val_2 = ((b[0]+1) / (b[1]+1)) - (b[0] / b[1]);

                return Double.compare(val_2, val_1);
            } );

            for(int[] clas: classes){
                double[] vals = new double[3];
                vals[0] = clas[0];
                vals[1] = clas[1];
                vals[2] = (double) clas[0] / clas[1];
                heap.add(vals);
            }

            while(extraStudents > 0){
                double[] vals = heap.poll();
                vals[0] += 1;
                vals[1] += 1;
                vals[2] = vals[0] / vals[1];

                heap.add(vals);
                extraStudents--;
            }

            double result = 0;
            while(!heap.isEmpty()){
                double[] vals = heap.poll();
                result += vals[2];
            }

            return result/classes.length;
        }
    }

}
