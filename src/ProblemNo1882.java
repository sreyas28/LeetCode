import java.util.Arrays;
import java.util.PriorityQueue;

public class ProblemNo1882 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1882().new Solution();
        System.out.println(Arrays.toString(a.assignTasks(new int[]{3, 3, 2}, new int[]{1, 2, 3, 2, 1, 2})));

    }

    class Solution {
        public int[] assignTasks(int[] servers, int[] tasks) {
            final int taskLength = tasks.length;

            PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                else return a[1] - b[1];
            });
            for (int i = 0; i < servers.length; i++) freeServers.offer(new int[]{i, servers[i]}); // index , server

            int[] result = new int[taskLength];

            int currentTime = 0;
            PriorityQueue<int[]> inUseServer = new PriorityQueue<>((a, b) -> a[2] - b[2]); // index, server, timeToFree
            for (int i = 0; i < taskLength; i++) {
                int currentTaskTime = tasks[i];

                if (freeServers.isEmpty()){
                    int[] poll = inUseServer.poll();
                    currentTime = Math.max(poll[2], currentTime);
                    freeServers.offer(new int[]{poll[0], poll[1]});
                }

                while (!inUseServer.isEmpty() && currentTime >= inUseServer.peek()[2]) {
                    int[] poll = inUseServer.poll();
                    freeServers.offer(new int[]{poll[0], poll[1]});
                }

                int[] freeServer = freeServers.poll();
                result[i] = freeServer[0];
                inUseServer.offer(new int[]{freeServer[0], freeServer[1], currentTime + currentTaskTime});
                currentTime = Math.max(i + 1, currentTime);
            }

            return result;
        }
    }

}
