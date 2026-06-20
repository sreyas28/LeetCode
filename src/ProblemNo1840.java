import java.util.*;

public class ProblemNo1840 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1840().new Solution();
        System.out.println(a.maxBuilding(5, new int[][]{{2, 1}, {4, 1}}));

    }

    class Solution {
        public int maxBuilding(int n, int[][] restrictions) {
            List<int[]> restrictionList = new ArrayList<>();

            restrictionList.add(new int[]{1, 0});
            restrictionList.addAll(Arrays.asList(restrictions));
            if (restrictionList.getLast()[0] != n) restrictionList.add(new int[]{n, n - 1});

            restrictionList.sort(Comparator.comparingInt(a -> a[0]));

            // left to right
            for (int i = 1; i < restrictionList.size(); ++i) {
                int dist = restrictionList.get(i)[0] - restrictionList.get(i - 1)[0];
                restrictionList.get(i)[1] = Math.min(restrictionList.get(i)[1], restrictionList.get(i - 1)[1] + dist);
            }

            // right to left
            for (int i = restrictionList.size() - 2; i >= 1; --i) {
                int dist = restrictionList.get(i + 1)[0] - restrictionList.get(i)[0];
                restrictionList.get(i)[1] = Math.min(restrictionList.get(i)[1], restrictionList.get(i + 1)[1] + dist);
            }

            int max = 0;
            for (int i = 0; i < restrictionList.size() - 1; i++) {
                int dist = restrictionList.get(i + 1)[0] - restrictionList.get(i)[0];
                max = Math.max(max, (dist + restrictionList.get(i + 1)[1] + restrictionList.get(i)[1]) / 2);
            }

            return max;
        }
    }

    // TLE
    class Solution_ {
        private final Map<Integer, Integer> restrictionsHeight = new HashMap<>();
        private int N;
        private int max = 0;

        public int maxBuilding(int n, int[][] restrictions) {
            this.N = n;
            for (int[] restriction : restrictions) restrictionsHeight.put(restriction[0] - 1, restriction[1]);

            allocator(1, 0);

            return max;
        }

        private boolean allocator(int index, int preHeight) {
            if (index >= N) {
                max = Math.max(max, preHeight);
                return true;
            }

            int restrict = Integer.MAX_VALUE;
            if (restrictionsHeight.containsKey(index)) restrict = restrictionsHeight.get(index);

            for (int i = 1; i >= -1; i--) {
                if (preHeight + i < 0) continue;
                if ((preHeight + i) <= restrict && allocator(index + 1, preHeight + i)) {
                    max = Math.max(max, preHeight + i);
                    return true;
                }
            }

            return false;
        }
    }

}
