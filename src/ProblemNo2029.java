public class ProblemNo2029 {
    public static void main(String[] args) {

        Solution a = new ProblemNo2029().new Solution();
        System.out.println(a.stoneGameIX(new int[]{20,3,20,17,2,12,15,17,4}));

    }

    class Solution {
        public boolean stoneGameIX(int[] stones) {
            final int div = 3;
            int[] count = new int[div];
            for (int i : stones) count[i % div]++;

            // starting with 1
            boolean try_1 = startDiff(count.clone(), 1, div);
            if (try_1) return true;


            // starting with 2
            return startDiff(count, 2, div);
        }

        private boolean startDiff(int[] count, int starter, int div){
            if (count[starter] > 0){
                int sum = starter;
                count[starter]--;

                while(true){
                    // Bob
                    int toChoose = sum % div;
                    if (count[toChoose] > 0) {
                        sum += toChoose;
                        count[toChoose]--;
                    }
                    else if (count[0] > 0) count[0]--;
                    else if (count[toChoose == 1 ? 2 : 1] == 0 && sum % div != 0) break;
                    else return true;

                    // Alice
                    toChoose = sum % div;
                    if (count[toChoose] > 0) {
                        sum += toChoose;
                        count[toChoose]--;
                    }
                    else if (count[0] > 0) count[0]--;
                    else break;
                }
            }

            return false;
        }

    }

}
