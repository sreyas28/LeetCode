public class ProblemNo1518 {

    public static void main(String[] args) {

    }

    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {

            int sum = numBottles;

            while(numBottles >= numExchange){
                sum += numBottles / numExchange;
                numBottles = (numBottles / numExchange) + (numBottles % numExchange);
            }

            return sum;
        }
    }

}
