import java.util.*;

public class ProblemNo805 {

    public static void main(String[] args) {
        Solution a = new ProblemNo805().new Solution();
//        System.out.println(a.splitArraySameAverage(new int[]{1, 2, 3, 4}));
        System.out.println(a.splitArraySameAverage(new int[]{18, 10, 5, 3}));
    }


    class Solution {

        private Map<Integer, List<Integer>> leftSubSet;
        private Map<Integer, List<Integer>> rightSubSet;

        public boolean splitArraySameAverage(int[] nums) {
            this.leftSubSet = new HashMap<>();
            this.rightSubSet = new HashMap<>();

            final int N = nums.length;
            final int S = Arrays.stream(nums).sum();

//            final double AVG = (double) S / N;
            if (N == 1) return false;

            subSetMaker(nums, 0, 0, 0, 0); // leftSubSet
            subSetMaker(nums, 1, 0, 0, 1); // rightSubSet

            for (int key : leftSubSet.keySet()) {
                leftSubSet.get(key).sort(Comparator.naturalOrder());
            }

            for (int key : rightSubSet.keySet()) {
                rightSubSet.get(key).sort(Comparator.naturalOrder());
            }

            for (int i = 1; i < N; i++) {
                if ((S * i) % N != 0) continue;
                int aSum = (S * i) / N;

                for (int a = 0; a <= i; a++) {
                    List<Integer> listLeft = leftSubSet.getOrDefault(a, new ArrayList<>());
                    List<Integer> listRight = rightSubSet.getOrDefault(i - a, new ArrayList<>());

                    for (int incompleteSum : listLeft) {
                        int toFind = aSum - incompleteSum;

                        if (binarySearch(listRight, toFind)) return true;
                    }
                }
            }

            return false;
        }

        private boolean binarySearch(List<Integer> list, int key) {
            if (list.isEmpty()) return false;
            int low = 0, high = list.size() - 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (list.get(mid) == key) return true;
                else if (list.get(mid) < key) low = mid + 1;
                else high = mid - 1;
            }

            return false;
        }

        private void subSetMaker(int[] nums, int index, int count, int sum, int type) {
            if (index >= nums.length) {
                if (type == 0) leftSubSet.computeIfAbsent(count, (k) -> new ArrayList<>()).add(sum);
                else rightSubSet.computeIfAbsent(count, (k) -> new ArrayList<>()).add(sum);
                return;
            }

            subSetMaker(nums, index + 2, count + 1, sum + nums[index], type);
            subSetMaker(nums, index + 2, count, sum, type);
        }

    }

    // both Exponential
    // BFS ONE
    class Solution__ {
        public boolean splitArraySameAverage(int[] nums) {
            final int N = nums.length;
            final int S = Arrays.stream(nums).sum();

            final double AVG = (double) S / N;

            if (N == 1) return false;

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0, 0}); // index, countLeft, leftSum

            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                int index = arr[0], countLeft = arr[1], leftSum = arr[2];

                if (index == N) {
                    if (countLeft == 0) continue;
                    else if (leftSum / countLeft == AVG) return true;
                    else if ((S - leftSum) / (N - countLeft) == AVG) return true;
                    continue;
                }

                queue.add(new int[]{index + 1, countLeft + 1, leftSum + nums[index]}); // taking
                queue.add(new int[]{index + 1, countLeft, leftSum}); // skipping
            }

            return false;
        }
    }

    // DFS ONE
    class Solution_ {
        public boolean splitArraySameAverage(int[] nums) {
            return dfs(nums, 0, 0, 0, 0, 0);
        }

        private boolean dfs(int[] nums, int index, int countLeft, int countRight, int leftSum, int rightSum) {
            if (nums.length == index) {
                if (countLeft == 0 || countRight == 0) return false;
                return leftSum / countLeft == rightSum / countRight;
            }

            //add it to left
            if (dfs(nums, index + 1, countLeft + 1, countRight, leftSum + nums[index], rightSum)) return true;
            //add it to right
            return dfs(nums, index + 1, countLeft, countRight + 1, leftSum, rightSum + nums[index]);
        }

    }


}
