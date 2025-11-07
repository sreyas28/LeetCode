import java.util.Arrays;

public class ProblemNo2528 {
    public static void main(String[] args) {

        ProblemNo2528.Solution a = new ProblemNo2528().new Solution();
        System.out.println(a.maxPower(new int[]{1,2,4,5,0}, 1, 2));

    }

    class Solution {

        public long maxPower(int[] stations, int r, int k) {
            int n = stations.length;

            long min = stations[0], max = stations[0] + k + 1;

            long[] diffArray = new long[n];
            for (int i = 0; i <= r; i++) diffArray[0] += stations[i];

            for (int i = 1; i < n; i++) {
                int last = i - r - 1 >= 0 ? stations[i - r - 1] : 0;
                int newNumber = i + r < n ? stations[i + r] : 0;
                diffArray[i] = newNumber - last;

                min = Math.min(min, stations[i]);
                max += stations[i];
            }

            System.out.println(Arrays.toString(diffArray));

            long result = min;
            while (min < max) {
                long mid = min + (max - min) / 2;

                if (check(mid, diffArray.clone(), k, r)) {
                    result = mid;
                    min = mid + 1;
                } else {
                    max = mid;
                }
            }

            return result;
        }

        private boolean check(long minVal, long[] diffArray, int k, int r) {

            long val = 0;

            for (int i = 0; i < diffArray.length; i++) {
                val += diffArray[i];
                if (val < minVal) {
                    long diff = minVal - val;
                    if (k >= diff) {
                        k -= (int) diff;
                        val += diff;
                        diffArray[i] += diff;
                        if((i + 2*r + 1) < diffArray.length) diffArray[i + 2*r +1] -= diff;
                    } else {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    class Solution_BruteForce {

        public long maxPower(int[] stations, int r, int k) {
            long[] power = new long[stations.length];
            for(int i=0; i<=r; i++) power[0] += stations[i];

            long min = stations[0], max = stations[0] + k + 1;

            for(int i=1; i<stations.length; i++){
                int previous = i-r-1 >= 0 ? stations[i-r-1] : 0;
                int newNumber = i+r < stations.length ? stations[i+r] : 0;
                power[i] = power[i-1] + newNumber - previous;

                min = Math.min(min, stations[i]);
                max += stations[i];
            }

            long result = min;
            while(min < max){
                long mid = min + (max-min)/2;

                if(check(mid, power.clone(), k, r)){
                    result = mid;
                    min = mid + 1;
                }
                else{
                    max = mid;
                }
            }

            return result;
        }

        private boolean check(long minVal, long[] power, int k, int r){

            for(int i = 0; i<power.length; i++){
                if(power[i] < minVal){
                    long diff = minVal - power[i];
                    if(k >= diff){
                        k -= (int) diff;
                        for(int b = i; b <= Math.min(i+r*2, power.length-1); b++) power[b] += diff;
                    }
                    else {
                        return false;
                    }
                }
            }

            return true;
        }

    }

}
