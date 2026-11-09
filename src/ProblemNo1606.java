import java.util.*;

public class ProblemNo1606 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1606().new Solution();
        System.out.println(a.busiestServers(3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 2, 3, 3, 3}));

    }

    class Solution {
        public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
            final int arrivalLength = arrival.length;

            int[] usage = new int[k];
            TreeSet<Integer> free = new TreeSet<>();
            for (int i = 0; i < k; i++) free.add(i);

            PriorityQueue<long[]> inUse = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1])); // index, timeToFree

            for (int i = 0; i < arrivalLength; i++) {
                int arrivalTime = arrival[i];

                while (!inUse.isEmpty() && arrivalTime >= inUse.peek()[1]) free.add((int) inUse.poll()[0]);

                if (free.isEmpty()) continue; // skip due to No server is Free

                Integer server = free.ceiling(i % k);
                if (server == null) server = free.first();

                free.remove(server);
                usage[server] += 1;
                inUse.offer(new long[]{server, load[i] + arrivalTime});
            }

            int max = Arrays.stream(usage).max().getAsInt();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (usage[i] == max) ans.add(i);
            }

            return ans;
        }
    }

}
