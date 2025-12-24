import java.util.*;

public class ProblemNo3074 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minimumBoxes(int[] apple, int[] capacity) {
            Arrays.sort(capacity);
            int used = 0;

            int sum = 0;
            for(int i: apple) sum += i;

            for(int i=capacity.length-1; i>=0; i--){
                if(sum > 0){
                    sum -= capacity[i];
                    used++;
                }
            }

            return used;
        }
    }

}
