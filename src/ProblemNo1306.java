import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo1306 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1306().new Solution();
        System.out.println(a.canReach(new int[]{3,0,2,1,2}, 2));

    }

    class Solution {
        public boolean canReach(int[] arr, int start) {
            final int N = arr.length;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            boolean[] visited = new boolean[N];

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                if (visited[cur]) continue;

                visited[cur] = true;
                if (arr[cur] == 0) return true;

                int option1 = cur + arr[cur];
                if (option1 < N)
                    queue.offer(option1);

                int option2 = cur - arr[cur];
                if (option2 >= 0)
                    queue.offer(option2);
            }

            return false;
        }
    }

}
