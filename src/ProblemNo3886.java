import java.util.*;

public class ProblemNo3886 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3886().new Solution();
//        System.out.println(a.sortableIntegers(new int[]{3, 1, 2}));
//        System.out.println(a.sortableIntegers(new int[]{7, 6, 5}));
        System.out.println(a.sortableIntegers(new int[]{1, 2, 1}));
//        System.out.println(a.sortableIntegers(new int[]{2,3,1,5,6,4,8,9,7,11,12,10}));

    }


    class Solution {
        public int sortableIntegers(int[] nums) {
            final int N = nums.length;

            List<Integer> numsList = new ArrayList<>();
            for (int i : nums) numsList.add(i);

            // O(NlogN)
            List<Integer> sorted = new ArrayList<>(numsList);
            sorted.sort(Comparator.naturalOrder());

            int sum = 0;
            for (int k = 1; k <= N; k++) {
                if (N % k != 0) continue;
                else if (valid(numsList, sorted, k)) sum += k;
            }

            return sum;
        }

        private boolean valid(List<Integer> nums, List<Integer> sorted, int k) {
            final int N = nums.size();

            for (int i = 0; i < N; i += k) {
                int notNice = 0, offset = 0;

                for (int j = 0; j < k; j++) {
                    int cur = nums.get(i + j);
                    int next = nums.get(i + (j + 1) % k);

                    if (cur > next) {
                        notNice++;
                        if (notNice > 1) return false;
                        offset = (j + 1) % k;
                    }
                }

                for (int j = 0; j < k; j++) {
                    if (!sorted.get(i + j).equals(nums.get(i + (j + offset) % k))) return false;
                }
            }

            return true;
        }
    }


    // Brute Force
    class Solution_ {
        public int sortableIntegers(int[] nums) {
            final int N = nums.length;

            List<Integer> numsList = new ArrayList<>();
            for (int i : nums) numsList.add(i);

            // O(NlogN)
            List<Integer> sorted = new ArrayList<>(numsList);
            sorted.sort(Comparator.naturalOrder());

            // O(N*N)
            int sum = 0;
            for (int k = 1; k <= N; k++) {
                if (N % k != 0) continue;
                else if (valid(numsList, sorted, k)) sum += k;
            }

            return sum;
        }

        private boolean valid(List<Integer> nums, List<Integer> sorted, int k) {
            final int N = nums.size();

            List<Integer> sortableList = new ArrayList<>();

            if (k == 1) sortableList.addAll(nums);
            else {
                for (int i = 0; i < N; i += k) {
                    List<Integer> ret = sortable(nums.subList(i, i + k), sorted.subList(i, i + k));
                    if (ret == null) return false;

                    sortableList.addAll(ret);
                }
            }

            for (int i = 0; i < N; i++) {
                if (Objects.equals(sortableList.get(i), sorted.get(i))) continue;
                return false;
            }

            return true;
        }

        private List<Integer> sortable(List<Integer> nums, List<Integer> sorted) {
            List<Integer> duplicated = new ArrayList<>(nums);
            duplicated.addAll(duplicated);

            int N = sorted.size(), M = duplicated.size();

            for (int i = 0; i <= M - N; i++) {
                if (isEqual(sorted, duplicated.subList(i, i + N))) return sorted;
            }

            return null;
        }

        private boolean isEqual(List<Integer> A, List<Integer> B) {
            for (int i = 0; i < A.size(); i++) {
                if (!A.get(i).equals(B.get(i))) return false;
            }
            return true;
        }

    }

}
