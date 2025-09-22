public class ProblemNo3005 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxFrequencyElements(int[] nums) {
            int[] arr = new int[102];

            for(int i: nums) arr[i]++;

            int maxFrequency = 0;
            int count = 0;

            for(int i: arr){
                if(i>maxFrequency) {
                    maxFrequency = i;
                    count = maxFrequency;
                }
                else if(i == maxFrequency) count += maxFrequency;
            }
            return count;
        }
    }

}
