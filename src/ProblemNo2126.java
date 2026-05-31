import java.util.Arrays;

public class ProblemNo2126 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            long planet = mass;
            Arrays.sort(asteroids);

            for(int asteroid:  asteroids) {
                if (planet >= asteroid) planet += asteroid;
                else return false;
            }

            return true;
        }
    }

}
