import java.util.*;

public class ProblemNo3607 {
    public static void main(String[] args) {

        ProblemNo3607.Solution a = new ProblemNo3607().new Solution();
        System.out.println(Arrays.toString(a.processQueries(3, new int[][]{}, new int[][]{{1,1},{2,1},{1,1}})));

    }

    class DSU {

        private int[] parent;

        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public void join(int u, int v) {
            parent[find(v)] = find(u);
        }
    }

    class Solution {

        public int[] processQueries(int c, int[][] connections, int[][] queries) {
            DSU dsu = new DSU(c + 1);

            for (int[] p : connections) {
                dsu.join(p[0], p[1]);
            }

            boolean[] online = new boolean[c + 1];
            int[] offlineCounts = new int[c + 1];
            Arrays.fill(online, true);
            Map<Integer, Integer> minimumOnlineStations = new HashMap<>();
            for (int[] q : queries) {
                int op = q[0];
                int x = q[1];
                if (op == 2) {
                    online[x] = false;
                    offlineCounts[x]++;
                }
            }

            for (int i = 1; i <= c; i++) {
                int root = dsu.find(i);
                if (!minimumOnlineStations.containsKey(root)) {
                    minimumOnlineStations.put(root, -1);
                }

                int station = minimumOnlineStations.get(root);
                if (online[i]) {
                    if (station == -1 || station > i) {
                        minimumOnlineStations.put(root, i);
                    }
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = queries.length - 1; i >= 0; i--) {
                int op = queries[i][0];
                int x = queries[i][1];
                int root = dsu.find(x);
                int station = minimumOnlineStations.get(root);

                if (op == 1) {
                    if (online[x]) {
                        ans.add(x);
                    } else {
                        ans.add(station);
                    }
                }

                if (op == 2) {
                    if (offlineCounts[x] > 1) {
                        offlineCounts[x]--;
                    } else {
                        online[x] = true;
                        if (station == -1 || station > x) {
                            minimumOnlineStations.put(root, x);
                        }
                    }
                }
            }

            Collections.reverse(ans);
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    class Solution_ {
        public int[] processQueries(int c, int[][] connections, int[][] queries) {
            int[] parent = new int[c + 1];
            for (int i = 1; i <= c; i++) parent[i] = i;

            // Union-Find setup
            for (int[] conn : connections) {
                union(conn[0], conn[1], parent);
            }

            Set<Integer> online = new HashSet<>();
            for (int i = 1; i <= c; i++) online.add(i);

            List<Integer> result = new ArrayList<>();
            for (int[] query : queries) {
                int type = query[0], node = query[1];
                if (type == 1) {
                    if (online.contains(node)) {
                        result.add(node);
                    } else {
                        int root = find(node, parent);
                        boolean found = false;
                        for (int i = 1; i <= c; i++) {
                            if (find(i, parent) == root && online.contains(i)) {
                                result.add(i);
                                found = true;
                                break;
                            }
                        }
                        if (!found) result.add(-1);
                    }
                } else {
                    online.remove(node);
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        private int find(int x, int[] parent) {
            if (parent[x] != x) parent[x] = find(parent[x], parent);
            return parent[x];
        }

        private void union(int x, int y, int[] parent) {
            int px = find(x, parent), py = find(y, parent);
            if (px != py) parent[py] = px;
        }
    }

    class Solution__ {
        public int[] processQueries(int c, int[][] connections, int[][] queries) {
            Map<Integer, Set<Integer>> connectionsMap = new HashMap<>();
            Set<Integer> Online = new HashSet<>();

            for(int i = 1; i <= c; i++){
                connectionsMap.put(i, new TreeSet<>());
                Online.add(i);
            }

            for(int[] connection: connections){
                connectionsMap.get(connection[0]).add(connection[1]);
                connectionsMap.get(connection[1]).add(connection[0]);
            }

            for(int i=1; i<= c; i++){
                connectionsMap.get(i).addAll(updator(i, new boolean[c], connectionsMap));
            }


            ArrayList<Integer> result = new ArrayList<>();
            for(int[] query: queries){
                if(query[0] == 1){
                    if(Online.contains(query[1])) result.add(query[1]);
                    else{
                        boolean x = false;
                        for(int con: connectionsMap.get(query[1])){
                            if(Online.contains(con)) {
                                result.add(con);
                                x = true;
                                break;
                            }
                        }
                        if(!x) result.add(-1);
                    }
                }

                else{
                    Online.remove(query[1]);
                }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        private Set<Integer> updator(int currentNode, boolean[] visited, Map<Integer, Set<Integer>> connectionMap){
            visited[currentNode-1] = true;
            Set<Integer> toVisit = connectionMap.get(currentNode);

            Set<Integer> visit = new HashSet<>();
            visit.add(currentNode);

            for(Integer i: toVisit){
                if(!visited[i-1]){
                    visit.add(i);
                    visit.addAll(updator(i, visited, connectionMap));
                }
            }

            return visit;
        }
    }

}
