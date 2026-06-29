public class ProblemNo1967 {
    public static void main(String[] args) {

    }

    class Solution {
        public int numOfStrings(String[] patterns, String word) {
            int count = 0;

            for (String pattern : patterns) {
                if (word.contains(pattern)) count++;
            }

            return count;
        }
    }

}
