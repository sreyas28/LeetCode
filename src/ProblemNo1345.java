import java.util.*;

public class ProblemNo1345 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minJumps(int[] arr) {
            final int n = arr.length;
            HashMap<Integer, List<Integer>> valIndies = new HashMap<>();

            for (int i = 0; i < n; i++) {
                valIndies.computeIfAbsent(arr[i], a -> new ArrayList<>()).add(i);
            }

            int count = 0;
            Queue<Integer> indexQueue = new LinkedList<>();
            boolean[] visited = new boolean[n];
            indexQueue.offer(0);
            visited[0] = true;

            while (!indexQueue.isEmpty()) {
                Queue<Integer> tempQueue = new LinkedList<>();

                while (!indexQueue.isEmpty()) {
                    int cur = indexQueue.poll();

                    if (cur == n - 1) return count;

                    if (cur + 1 < n && !visited[cur + 1]) {
                        tempQueue.offer(cur + 1);
                        visited[cur + 1] = true;
                    }
                    if (cur - 1 >= 0 && !visited[cur - 1]) {
                        tempQueue.offer(cur - 1);
                        visited[cur - 1] = true;
                    }

                    for (int index : valIndies.getOrDefault(arr[cur], new ArrayList<>())) {
                        if (!visited[index]) {
                            tempQueue.offer(index);
                            visited[index] = true;
                        }
                    }

                    valIndies.remove(arr[cur]);

                }

                indexQueue = tempQueue;
                count++;
            }


            return -1;
        }
    }

}
