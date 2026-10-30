import java.util.*;

public class ProblemNo3970 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3970().new Solution();
        System.out.println(a.shortestPath(3, new int[][]{{0, 1, 1}, {1, 2, 1}, {0, 2, 3}}, "aab", 1));
//        System.out.println(a.shortestPath(3, new int[][]{{0, 1, 1}, {1, 2, 1}}, "aaa", 2));

    }

    class Solution {

        private class Node {
            int index;
            int weightSum;
            int count;

            Node(int index, int weightSum, int count) {
                this.index = index;
                this.weightSum = weightSum;
                this.count = count;
            }
        }

        public int shortestPath(int n, int[][] edges, String labels, int k) {
            Map<Integer, List<int[]>> map = new HashMap<>();

            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                map.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, w});
            }

            int[][] distances = new int[n][k + 1];
            for (int[] dis : distances) Arrays.fill(dis, Integer.MAX_VALUE);

            distances[0][0] = 1;

            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weightSum - b.weightSum);
            pq.offer(new Node(0, 0, 1));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (cur.index == n - 1) return cur.weightSum;

                char currChar = labels.charAt(cur.index);
                for (int[] next : map.getOrDefault(cur.index, new ArrayList<>())) {
                    int weight = next[1];
                    int count = cur.count;

                    char nextChar = labels.charAt(next[0]);
                    if (nextChar == currChar) count++;
                    else count = 1;

                    if (count > k) continue;

                    int newWeightSum = weight + cur.weightSum;
                    if (distances[next[0]][count] > newWeightSum) {
                        pq.offer(new Node(next[0], newWeightSum, count));
                        distances[next[0]][count] = newWeightSum;
                    }
                }
            }

            return -1;
        }
    }


    // TLE
    class Solution_ {
        private int N, limit;
        private String labels;

        private int[][] adjMatrix;

        public int shortestPath(int n, int[][] edges, String labels, int k) {
            this.N = n;
            this.limit = k;
            this.labels = labels;

            this.adjMatrix = new int[N][N];

            for (int[] edge : edges) {
                if (adjMatrix[edge[0]][edge[1]] == 0) adjMatrix[edge[0]][edge[1]] = edge[2];
                else adjMatrix[edge[0]][edge[1]] = Math.min(adjMatrix[edge[0]][edge[1]], edge[2]);
            }

            boolean[] visited = new boolean[N];
            visited[0] = true;
            return DFS(0, labels.charAt(0), 1, visited);
        }

        private int DFS(int curr, char currChar, int count, boolean[] visited) {
            if (curr == N - 1) return 0;

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < this.N; i++) {
                int tempCount = count;
                char tempChar = currChar;

                if (tempChar == labels.charAt(i)) tempCount++;
                else {
                    tempChar = labels.charAt(i);
                    tempCount = 1;
                }

                if (visited[i] || adjMatrix[curr][i] == 0 || tempCount > limit) continue;

                visited[i] = true;
                int temp = DFS(i, tempChar, tempCount, visited);
                if (temp != -1) min = Math.min(min, temp + adjMatrix[curr][i]);
                visited[i] = false;
            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }
    }

}
