import java.util.Arrays;

public class ProblemNo4012 {
    public static void main(String[] args) {

        Solution a = new ProblemNo4012().new Solution();
//        System.out.println(Arrays.toString(a.countTasks(new int[]{1,4,4}, new  int[]{9,1,4})));
//        System.out.println(Arrays.toString(a.countTasks(new int[]{2,3,4}, new  int[]{20,4,5})));
//        System.out.println(Arrays.toString(a.countTasks(new int[]{1,1,3,3,8}, new  int[]{2,9,5,3,9})));
        System.out.println(Arrays.toString(a.countTasks(new int[]{1,1,3,9,10}, new  int[]{8,10,5,4,2})));


    }

    class Solution {
        public int[] countTasks(int[] tasks, int[] shifts) {
            final int N = tasks.length;
            final int M = shifts.length;

            long[] prefixTasks = new long[N + 1];
            for (int i = 0; i < N; i++) {
                prefixTasks[i + 1] = prefixTasks[i] + tasks[i];
            }

            int[] result = new int[M];

            int lastLow = 0;
            long carryTime = 0;
            for(int i = 0; i < M; i++) {
                int temp = binarySearch(prefixTasks, shifts[i] + carryTime, lastLow);

                if (temp == -1) {
                    carryTime = carryTime + shifts[i];
                    result[i] = N - lastLow;
                }

                else {
                    result[i] = N - temp;

                    if(temp == N) carryTime = 0;
                    else carryTime = carryTime + shifts[i] - (prefixTasks[temp] - prefixTasks[lastLow]);

                    lastLow = temp % N;
                }
            }

            return result;
        }

        private int binarySearch(long[] array, long target, int lastLow) {
            long offset = array[lastLow];
            int low = lastLow + 1, high = array.length - 1;


            int ansIndex = -1;
            while (low <= high) {
                int mid = (low + high) / 2;

                if  ((array[mid] - offset) <= target) {
                    ansIndex = mid;
                    low = mid + 1;
                }
                else high = mid - 1;
            }

            return ansIndex;
        }

    }

}
