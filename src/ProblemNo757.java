import java.util.*;

public class ProblemNo757 {
    public static void main(String[] args) {

        ProblemNo757.Solution a = new ProblemNo757().new Solution();
        System.out.println(a.intersectionSizeTwo(new int[][] {{1,3},{3,7},{5,7},{7,8}}));
    }

    class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            List<Integer> vals = new ArrayList<>();

            Arrays.sort(intervals, (a,b) -> b[0] - a[0] );

            for(int[] interval: intervals){
                int last = !vals.isEmpty() ? vals.getLast() : -1;
                int secondLast = vals.size() > 1 ? vals.get(vals.size() - 2) : -1;

                if(last >= interval[0] && last <= interval[1] &&
                        secondLast >= interval[0] && secondLast <= interval[1]) continue;

                else if (last >= interval[0] && last <= interval[1]) vals.add(interval[0]);

                else{
                    vals.add(interval[0] + 1);
                    vals.add(interval[0]);
                }
            }

            return vals.size();
        }
    }

}
