public class ProblemNo3477 {
    public static void main(String[] args) {

        ProblemNo3477.Solution a = new ProblemNo3477().new Solution();
        System.out.println(a.numOfUnplacedFruits(new int[]{4,2,5}, new int[]{3,5,4}));

    }

    class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            boolean[] basketUsed = new boolean[baskets.length];
            int remain = baskets.length;

            for(int i: fruits){
                for(int j = 0; j < baskets.length; j++){
                    if(baskets[j] >= i && !basketUsed[j]){
                        basketUsed[j] = true;
                        remain--;
                        break;
                    }
                }
            }
            return remain;
        }
    }

}
