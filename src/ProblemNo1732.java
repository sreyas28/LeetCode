public class ProblemNo1732 {
    public static void main(String[] args) {

    }

    class Solution {
        public int largestAltitude(int[] gain) {
            int altitude = 0;
            int maxAltitude = 0;

            for(int i: gain){
                altitude += i;
                maxAltitude = Math.max(maxAltitude,altitude);
            }

            return maxAltitude;
        }
    }

}
