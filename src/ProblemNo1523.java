public class ProblemNo1523 {
    class Solution {
        public int countOdds(int low, int high) {
            int val = high - low + 1;

            if(high % 2 != 0) return (int) Math.ceil((double) val / 2);

            return (int) Math.floor((double) val / 2);
        }
    }
}
