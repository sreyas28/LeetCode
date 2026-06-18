public class ProblemNo1344 {
    public static void main(String[] args) {

    }

    class Solution {
        public double angleClock(int hour, int minutes) {
            final int DEGREE_PER_MINUTES = 6;
            final int DEGREE_PER_HOUR = 30;
            final double DEGREE_PER_MINUTES_PER_HOUR = 0.5;
            final int MOD = 12;

            hour %= MOD;

            double hourAngle = (hour * DEGREE_PER_HOUR) + (minutes * DEGREE_PER_MINUTES_PER_HOUR);
            double minuteAngle = minutes * DEGREE_PER_MINUTES;

            double ans = Math.abs(hourAngle - minuteAngle);

            return Math.min(360 - ans, ans);
        }
    }

}
