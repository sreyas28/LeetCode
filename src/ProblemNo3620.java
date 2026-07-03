import java.util.*;

public class ProblemNo3620 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3620().new Solution();
//        System.out.println(a.findMaxPathScore(new int[][]{{0,1,5},{1,3,10},{0,2,3},{2,3,4}}, new boolean[]{true,true,true,true}, 10));
        System.out.println(a.findMaxPathScore(new int[][]{{0, 1, 7}, {1, 4, 5}, {0, 2, 6}, {2, 3, 6}, {3, 4, 2}, {2, 4, 6}}, new boolean[]{true, true, true, false, true}, 12));

    }

    class Solution {
        public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
            final int NODES = online.length;
            Map<Integer, List<int[]>> adj = new HashMap<>();
            int maxWeight = 0;

            for (int[] edge : edges) {
                adj.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(new int[]{edge[1], edge[2]}); // node-a -> node-b and cost
                maxWeight = Math.max(maxWeight, edge[2]);
            }

            int left = 0, right = maxWeight, ans = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if(Dijkstra(adj,online,NODES,mid) <= k){
                    ans = mid;
                    left = mid+1;
                }
                else right = mid-1;
            }

            return ans;
        }

        private long Dijkstra(Map<Integer, List<int[]>> adj, boolean[] online, int N, int minEdge) {
            long[] dist = new long[N];
            Arrays.fill(dist, Long.MAX_VALUE);

            dist[0] = 0;
            PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
            pq.offer(new long[]{0, 0});

            while (!pq.isEmpty()) {
                long[] current = pq.poll();
                int node = (int)current[0];
                long curCost = current[1];

                if (curCost > dist[node]) continue;
                else if (node == N - 1) return curCost;

                for(int[] edge : adj.getOrDefault(node, new ArrayList<>())) {
                    if (!online[edge[0]] || edge[1] < minEdge) continue;

                    long newCost = curCost + edge[1];
                    if (newCost < dist[edge[0]]) {
                        dist[edge[0]] = newCost;
                        pq.offer(new long[]{edge[0], newCost});
                    }
                }
            }


            return dist[N - 1];
        }

    }

    // TLE
    class Solution_ {
        public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
            final int NODES = online.length;
            Map<Integer, List<int[]>> adj = new HashMap<>();

            for (int[] edge : edges) {
                adj.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(new int[]{edge[1], edge[2]}); // node-a -> node-b and cost
            }

            Queue<long[]> queue = new LinkedList<>();
            queue.add(new long[]{0, 0, Integer.MAX_VALUE}); // node, sum and min

            int ans = -1;

            while (!queue.isEmpty()) {
                long[] cur = queue.poll();

                if (cur[0] == NODES - 1) {
                    ans = Math.toIntExact(Math.max(ans, cur[2]));
                    continue;
                }

                for (int[] adjNode : adj.getOrDefault((int)cur[0],  new ArrayList<>())) {
                    if (!online[adjNode[0]]) continue;
                    else if (cur[1] + adjNode[1] > k) continue;

                    queue.add(new long[]{adjNode[0], cur[1] + adjNode[1], Math.min(cur[2], adjNode[1])});
                }

            }

            return ans;
        }
    }

}
