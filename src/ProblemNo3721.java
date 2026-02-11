import java.util.*;

public class ProblemNo3721 {
    public static void main(String[] args) {

    }

    //Optimized One ☝️
    class Solution {

        int[] segMin;
        int[] segMax;
        int[] lazy;

        public int longestBalanced(int[] nums) {
            int n = nums.length;
            segMin = new int[4 * n];
            segMax = new int[4 * n];
            lazy = new int[4 * n];

            int max = 0;

            Map<Integer, Integer> map = new HashMap<>();
            int[] cumSum = new int[n];

            for (int r = 0; r < n; r++) {
                int val = (nums[r] % 2 == 0) ? 1 : -1;

                int prev = map.getOrDefault(nums[r], -1);

                if (prev != -1) lazyProp(0, prev, -val, 0, 0, n - 1);

                lazyProp(0, r, val, 0, 0, n - 1);

                int l = findLeftMostZero(0, 0, n - 1);
                if (l != -1) max = Math.max(max, r - l + 1);

                map.put(nums[r], r);
            }

            return max;
        }

        private void lazyProp(int rangeLeft, int rangeRight, int val, int i, int left, int right) {
            propagate(i, left, right);

            if (left > rangeRight || right < rangeLeft) return;
            else if (left >= rangeLeft && right <= rangeRight) {
                lazy[i] += val;
                propagate(i, left, right);
                return;
            }

            int mid = left + (right - left) / 2;
            lazyProp(rangeLeft, rangeRight, val, i * 2 + 1, left, mid);
            lazyProp(rangeLeft, rangeRight, val, i * 2 + 2, mid + 1, right);

            segMin[i] = Math.min(segMin[i * 2 + 1], segMin[i * 2 + 2]);
            segMax[i] = Math.max(segMax[i * 2 + 1], segMax[i * 2 + 2]);
        }

        private void propagate(int i, int left, int right) {
            if (lazy[i] != 0) {
                segMin[i] += lazy[i];
                segMax[i] += lazy[i];

                if (left != right) {
                    lazy[2 * i + 1] += lazy[i];
                    lazy[2 * i + 2] += lazy[i];
                }

                lazy[i] = 0;
            }
        }

        private int findLeftMostZero(int i, int left, int right) {
            propagate(i, left, right);

            if (segMin[i] > 0 || segMax[i] < 0) return -1;
            if (left == right) return left;

            int mid = left + (right - left) / 2;
            int leftRes = findLeftMostZero(i * 2 + 1, left, mid);
            if(leftRes != -1) return leftRes;

            return findLeftMostZero(i * 2 + 2, mid + 1, right);
        }


    }

    // brute Force
    class Solution_ {
        public int longestBalanced(int[] nums) {
            int n = nums.length;

            int[] cumSum = new int[n];
            Map<Integer, Integer> map = new HashMap<>();

            int max = 0;

            for (int i = 0; i < n; i++) {
                int val = (nums[i] % 2 == 0) ? 1 : -1;

                int prev = map.getOrDefault(nums[i], -1);

                if (prev != -1) {
                    for (int l = 0; l <= prev; l++) {
                        cumSum[l] -= val;
                    }
                }

                for (int l = 0; l <= i; l++) {
                    cumSum[l] += val;

                    if (cumSum[l] == 0) {
                        max = Math.max(max, i - l + 1);
                    }
                }

                map.put(nums[i], i);
            }

            return max;
        }
    }

}
