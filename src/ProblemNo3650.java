import java.util.*;

public class ProblemNo3650 {
    public static void main(String[] args) {

        ProblemNo3650.Solution p = new ProblemNo3650().new Solution();
//        System.out.println(p.minCost(2, new int[][]{{0, 1, 17}, {1, 0, 12}}));
        System.out.println(p.minCost(4, new int[][]{{1, 0, 13}, {2, 3, 15}, {0, 1, 19}, {0, 2, 9}, {1, 2, 10}}));

    }

    class Solution {
        public int minCost(int n, int[][] edges) {
            List<int[]>[] adj = new ArrayList[n];
            for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                adj[u].add(new int[]{v, w});       // forward edge
                adj[v].add(new int[]{u, w * 2});   // backward edge (double cost)
            }

            int res = Dijkstra(adj, n);
            return res == Integer.MAX_VALUE ? -1 : res;
        }

        private int Dijkstra(List<int[]>[] adj, int n) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;
            pq.offer(new int[]{0, 0}); // {distance, node}

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int d = cur[0], u = cur[1];

                if (d > dist[u]) continue;

                for (int[] edge : adj[u]) {
                    int v = edge[0], w = edge[1];
                    if (d + w < dist[v]) {
                        dist[v] = d + w;
                        pq.offer(new int[]{dist[v], v});
                    }
                }
            }

            return dist[n - 1];
        }
    }

    // MLE
    class Solution__ {
        public int minCost(int n, int[][] edges) {
            int[][] adj =  new int[n][n];

            for (int[] edge : edges) {
                int weight = edge[2], twiceWeight = edge[2] * 2;

                if(adj[edge[0]][edge[1]] != 0) adj[edge[0]][edge[1]] = Math.min(adj[edge[0]][edge[1]], weight);
                else  adj[edge[0]][edge[1]] = weight;

                if(adj[edge[1]][edge[0]] != 0) adj[edge[1]][edge[0]] = Math.min(adj[edge[1]][edge[0]], twiceWeight);
                else  adj[edge[1]][edge[0]] = twiceWeight;
            }

            int res = Dijkstra(adj);

            return res == Integer.MAX_VALUE ? -1 : res;
        }

        private int Dijkstra(int[][] adj){
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]); // weight and node

            int[] dist = new int[adj.length];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;
            pq.offer(new int[]{0,0});

            while(!pq.isEmpty()){
                int[] cur = pq.poll();

                int weight = cur[0];
                int vertex = cur[1];

                if(weight > dist[vertex]) continue;

                for(int i = 0; i < adj[vertex].length; i++){
                    if(adj[vertex][i] == 0) continue;

                    if(adj[vertex][i] + weight < dist[i]){
                        dist[i] = adj[vertex][i] + weight;
                        pq.offer(new int[]{dist[i], i});
                    }
                }
            }

            return dist[adj.length-1];
        }

    }



    class Solution_ {

        int[][] DP;

        public int minCost(int n, int[][] edges) {
            DP = new int[n][n];
            int[][][] adj = new int[n][n][2]; // going and coming
            for (int[] edge : edges) {
                adj[edge[0]][edge[1]][0] = edge[2];
                adj[edge[1]][edge[0]][1] = edge[2];
            }

//            System.out.println(Arrays.deepToString(adj));
            int res = DFS(adj, 0, 0, new boolean[n]);
            return res == Integer.MAX_VALUE ? -1 : res;
        }

        private int DFS(int[][][] adj, int prevSum, int node, boolean[] visited) {
            if (node == adj.length - 1) return prevSum;

            visited[node] = true;
            int[][] connectedNodes = adj[node];

            int cost = Integer.MAX_VALUE;

            for (int nextNode = 0; nextNode < connectedNodes.length; nextNode++) {

                int[] weights = adj[node][nextNode];

                if (visited[nextNode]) continue;

                if(DP[node][nextNode] != 0) cost = Math.min(cost, DP[node][nextNode]);
                else {
                    if (weights[0] != 0) {
                        cost = Math.min(cost, DFS(adj, weights[0], nextNode, visited));
                        visited[nextNode] = false;
                    }
                    if (weights[1] != 0) {
                        cost = Math.min(cost, DFS(adj, weights[1] * 2, nextNode, visited));
                        visited[nextNode] = false;
                    }

                    DP[node][nextNode] = cost;
                }
            }
            if (cost == Integer.MAX_VALUE) return cost;
            return prevSum + cost;
        }

    }

}
