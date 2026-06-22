public class ProblemNo1189 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxNumberOfBalloons(String text) {
            int b = 0, a = 0, l = 0, o = 0, n = 0;

            for (char c : text.toCharArray()) {
                switch (c){
                    case 'b' -> b++;
                    case 'a' -> a++;
                    case 'l' -> l++;
                    case 'o' -> o++;
                    case 'n' -> n++;
                }
            }

            int maxBalloons = b;
            maxBalloons = Math.min(maxBalloons, a);
            maxBalloons = Math.min(maxBalloons, l / 2);
            maxBalloons = Math.min(maxBalloons, o / 2);
            maxBalloons = Math.min(maxBalloons, n);


            return maxBalloons;
        }
    }

}
