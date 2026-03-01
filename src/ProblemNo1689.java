public class ProblemNo1689 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minPartitions(String n) {
            int max = n.charAt(0) - '0';

            for(char c : n.toCharArray()){
                max = Math.max(max, c-'0');
            }

            return max;
        }
    }

}
