public class ProblemNo3838 {
    public static void main(String[] args) {

    }

    class Solution {
        public String mapWordWeights(String[] words, int[] weights) {

            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                int sum = 0;
                for (char c : word.toCharArray()) sum += weights[c - 'a'];

                sum %= 26;

                sb.append((char)('z' - sum));
            }

            return sb.toString();
        }
    }

}
