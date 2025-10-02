public class ProblemNo3100 {
    public static void main(String[] args) {

        ProblemNo3100.Solution a = new ProblemNo3100(). new Solution();
        System.out.println(a.maxBottlesDrunk(13, 6));

    }

    class Solution {
        public int maxBottlesDrunk(int numBottles, int numExchange) {
            int sum = numBottles;
            int emptyBottle = numBottles;
            int fullBottle = 0;


            while(emptyBottle >= numExchange){
                // refactoring
                while (emptyBottle >= numExchange) {
                    emptyBottle -= numExchange;
                    fullBottle += 1;
                    numExchange += 1;
                }

                sum += fullBottle;
                emptyBottle += fullBottle;
                fullBottle = 0;
            }

            return sum;
        }
    }

}
