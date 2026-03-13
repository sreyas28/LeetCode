import javax.annotation.processing.SupportedSourceVersion;
import java.util.Arrays;

public class ProblemNo3296 {
    public static void main(String[] args) {
        ProblemNo3296.Solution sol = new ProblemNo3296().new Solution();
        System.out.println(sol.minNumberOfSeconds(3, new int[]{1, 6}));
    }

    class Solution {
        public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
            long minTime = 1, maxTime = Arrays.stream(workerTimes).max().getAsInt() * ((long) mountainHeight * (mountainHeight + 1) / 2);

            while (minTime < maxTime) {
                long mid = (minTime + maxTime) / 2;

                if (checkTime(mid, workerTimes, mountainHeight)) maxTime = mid;
                else minTime = mid + 1;

            }

            return minTime;
        }

        private boolean checkTime(long time, int[] workerTimes, int mountainHeight) {
            long sumWork = 0;

            for (int workerTime : workerTimes) {
                long val = (long) (Math.sqrt(((double) time / workerTime) * 2 + 0.25) - 0.5);
                sumWork += val;
            }

            return sumWork >= mountainHeight;
        }

    }
}
