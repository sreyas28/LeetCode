import java.util.*;

public class ProblemNo3414 {
    public static void main(String[] args) {
        List<List<Integer>> arrayList = new ArrayList<>();
//        int[][] arr = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}, {6, 9, 3}, {6, 7, 1}, {8, 9, 1}};
        int[][] arr = {{5, 8, 1}, {6, 7, 7}, {4, 7, 3}, {9, 10, 6}, {7, 8, 2}, {11, 14, 3}, {3, 5, 5}};

        for (int[] row : arr) {
            List<Integer> list = new ArrayList<>();
            for (int i : row) list.add(i);
            arrayList.add(list);
        }

        Solution a = new ProblemNo3414().new Solution();
        System.out.println(Arrays.toString(a.maximumWeight(arrayList)));

    }

    class Solution {
        private static class Group {
            long score;
            List<Integer> indies;

            public Group() {
                this.score = 0;
                this.indies = new ArrayList<>();
            }

            public Group(Group g) {
                this.score = g.score;
                this.indies = new ArrayList<>(g.indies);
            }

        }

        private int N;

        public int[] maximumWeight(List<List<Integer>> intervals) {
            this.N = intervals.size();

            for (int i = 0; i < N; i++) intervals.get(i).add(i);

            intervals.sort((a, b) -> {
                if (a.get(0) == b.get(0)) return a.get(1) - b.get(1);
                return a.get(0) - b.get(0);
            });

            int[] nextGoodIndex = new int[N];
            for (int i = 0; i < N; i++) {
                // Binary Search for nextGoodIndex
                int left = i + 1, right = N - 1, nextIndex = N;
                int rightBound = intervals.get(i).get(1);

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (intervals.get(mid).getFirst() > rightBound) {
                        nextIndex = mid;
                        right = mid - 1;
                    } else left = mid + 1;
                }

                nextGoodIndex[i] = nextIndex;
            }


            Group group = kindOfKnapsack(intervals, nextGoodIndex);

            int[] res = new int[group.indies.size()];
            for (int i = 0; i < group.indies.size(); i++) {
                res[i] = group.indies.get(i);
            }

            Arrays.sort(res);
            return res;
        }

        private Group kindOfKnapsack(List<List<Integer>> intervals, int[] nextGoodIndex) {
            final int GroupSize = 4;
            Group[][] memo = new Group[GroupSize + 1][N + 1];


            for (int curIndex = N - 1; curIndex >= 0; curIndex--) {
                for (int size = 1; size <= GroupSize; size++) {

                    // skipping
                    Group skip = memo[size][curIndex + 1];
                    if (skip == null) skip = new Group();

                    // taking
                    Group takingSource = memo[size - 1][nextGoodIndex[curIndex]];
                    Group taking = (takingSource == null) ? new Group() : new Group(takingSource);

                    taking.indies.add(intervals.get(curIndex).get(3));
                    taking.score += intervals.get(curIndex).get(2);


                    if (taking.score > skip.score) memo[size][curIndex] = new Group(taking);
                    else if (taking.score < skip.score) memo[size][curIndex] = new Group(skip);

                        // we need Lexicographical smaller Array
                    else {
                        taking.indies.sort(Comparator.naturalOrder());
                        skip.indies.sort(Comparator.naturalOrder());

                        if (lexicographical(taking.indies, skip.indies)) memo[size][curIndex] = new Group(skip);
                        else memo[size][curIndex] = new Group(taking);
                    }
                }
            }


            return new Group(memo[GroupSize][0]);
        }

        // True is ListA is Greater than ListB and wise versa
        private boolean lexicographical(List<Integer> listA, List<Integer> listB) {
            for (int idx = 0; idx < Math.min(listA.size(), listB.size()); idx++) {
                if (listA.get(idx) > listB.get(idx)) return true;
                if (listA.get(idx) < listB.get(idx)) return false;
            }

            return listA.size() > listB.size();
        }
    }


    // Top Down DFS it is fast but not fast as Bottoms UP DFS
    class Solution_ {
        private static class Group {
            long score;
            List<Integer> indies;

            public Group() {
                this.score = 0;
                this.indies = new ArrayList<>();
            }

            public Group(Group g) {
                this.score = g.score;
                this.indies = new ArrayList<>(g.indies);
            }

        }

        private int N;
        private Group[][] memo;

        public int[] maximumWeight(List<List<Integer>> intervals) {
            this.N = intervals.size();
            this.memo = new Group[N + 1][5];

            for (int i = 0; i < N; i++) intervals.get(i).add(i);

            intervals.sort((a, b) -> {
                if (a.get(0) == b.get(0)) return a.get(1) - b.get(1);
                return a.get(0) - b.get(0);
            });

            int[] nextGoodIndex = new int[N];
            for (int i = 0; i < N; i++) {
                // Binary Search for nextGoodIndex
                int left = i + 1, right = N - 1, nextIndex = N;
                int rightBound = intervals.get(i).get(1);

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (intervals.get(mid).getFirst() > rightBound) {
                        nextIndex = mid;
                        right = mid - 1;
                    } else left = mid + 1;
                }

                nextGoodIndex[i] = nextIndex;
            }

            Group group = dfs(intervals, 4, 0, nextGoodIndex);

            int[] res = new int[group.indies.size()];
            for (int i = 0; i < group.indies.size(); i++) {
                res[i] = group.indies.get(i);
            }

            Arrays.sort(res);
            return res;
        }

        private Group dfs(List<List<Integer>> intervals, int groupSize, int i, int[] nextGoodIndex) {
            if (groupSize <= 0 || i == N) return new Group();

            if (memo[i][groupSize] != null) return new Group(memo[i][groupSize]);

            // skip
            Group skip = dfs(intervals, groupSize, i + 1, nextGoodIndex);

            //taking
            Group taking = dfs(intervals, groupSize - 1, nextGoodIndex[i], nextGoodIndex);
            taking.indies.add(intervals.get(i).get(3));
            taking.score += intervals.get(i).get(2);


            if (taking.score > skip.score) memo[i][groupSize] = new Group(taking);
            else if (taking.score < skip.score) memo[i][groupSize] = new Group(skip);

                // we need Lexicographical smaller Array
            else {
                taking.indies.sort(Comparator.naturalOrder());
                skip.indies.sort(Comparator.naturalOrder());

                if (lexicographical(taking.indies, skip.indies)) memo[i][groupSize] = new Group(skip);
                else memo[i][groupSize] = new Group(taking);
            }

            return new Group(memo[i][groupSize]);
        }

        // True is ListA is Greater than ListB and wise versa
        private boolean lexicographical(List<Integer> listA, List<Integer> listB) {
            for (int idx = 0; idx < Math.min(listA.size(), listB.size()); idx++) {
                if (listA.get(idx) > listB.get(idx)) return true;
                if (listA.get(idx) < listB.get(idx)) return false;
            }

            return listA.size() > listB.size();
        }
    }

}
