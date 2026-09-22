import java.util.Arrays;

public class ProblemNo3525 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3525().new Solution();
        System.out.println(Arrays.toString(a.resultArray(new int[]{1, 2, 3, 4, 5}, 3, new int[][]{{2, 2, 0, 2}, {3, 3, 3, 0}, {0, 1, 0, 1}})));
//        System.out.println(Arrays.toString(a.resultArray(new int[]{3, 9, 10, 10}, 3, new int[][]{{1, 26, 3, 2}, {3, 3, 3, 0}, {0, 1, 0, 1}})));

    }

    class Solution {
        private Node[] segmentTree;
        private int mod;

        class Node {
            int productMod;
            int[] remainders;

            Node(int productMod) {
                this.productMod = productMod;
                this.remainders = new int[mod];
            }

            Node(Node left, Node right) {
                this.productMod = (left.productMod * right.productMod) % mod;
                this.remainders = new int[mod];

                for (int r = 0; r < remainders.length; r++) {
                    this.remainders[r] += left.remainders[r];
                    this.remainders[(left.productMod * r) % mod] += right.remainders[r];
                }
            }
        }

        public int[] resultArray(int[] nums, int k, int[][] queries) {
            final int N = nums.length;

            this.mod = k;
            this.segmentTree = new Node[N * 4];

            buildSegmentTree(0, 0, N - 1, nums);

            int[] ans = new int[queries.length];
            int i = 0;
            for (int[] query : queries) {
                int index = query[0];
                int value = query[1];
                int start = query[2];
                int xi = query[3];

                updateSegmentTree(0, 0, N - 1, index, value);

                ans[i++] = segTreeQuery(0, 0, N - 1, start, N - 1).remainders[xi];
            }


            return ans;
        }

        private void buildSegmentTree(int i, int left, int right, int[] nums) {
            if (left == right) {
                int val = nums[left] % mod;
                segmentTree[i] = new Node(val);
                segmentTree[i].remainders[val]++;
                return;
            }

            int mid = left + (right - left) / 2;
            buildSegmentTree(2 * i + 1, left, mid, nums);
            buildSegmentTree(2 * i + 2, mid + 1, right, nums);

            segmentTree[i] = new Node(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
        }

        private void updateSegmentTree(int i, int left, int right, int index, int num) {
            if (left == right) {
                int val = num % mod;
                segmentTree[i] = new Node(val);
                segmentTree[i].remainders[val]++;
                return;
            }

            int mid = left + (right - left) / 2;

            if (left <= index && index <= mid) updateSegmentTree(2 * i + 1, left, mid, index, num);
            else if (mid + 1 <= index && index <= right) updateSegmentTree(2 * i + 2, mid + 1, right, index, num);

            segmentTree[i] = new Node(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
        }

        private Node segTreeQuery(int i, int left, int right, int start, int end) {
            if (left >= start && right <= end) {
                return segmentTree[i];
            }

            int mid = left + (right - left) / 2;

            if (end <= mid) return segTreeQuery(2 * i + 1, left, mid, start, end);
            else if (start > mid) return segTreeQuery(2 * i + 2, mid + 1, right, start, end);
            else {
                return new Node(segTreeQuery(2 * i + 1, left, mid, start, end), segTreeQuery(2 * i + 2, mid + 1, right, start, end));
            }
        }

    }


    // totally Wrong
    class Solution_ {
        public int[] resultArray(int[] nums, int k, int[][] queries) {
            final int N = nums.length;

            int[] prefixProduct = new int[N];
            int[][] modCount = new int[N][k];

            prefixProduct[0] = nums[0] % k;
            modCount[0][prefixProduct[0]]++;

            for (int i = 1; i < N; i++) {
                prefixProduct[i] = (nums[i] * prefixProduct[i - 1]) % k;

                modCount[i] = modCount[i - 1].clone();
                modCount[i][prefixProduct[i]]++;
            }

            //update
            int[] result = new int[queries.length];
            int idx = 0;
            for (int[] query : queries) {
                int index = query[0];
                int value = query[1];
                int start = query[2];
                int xi = query[3];

                if (nums[index] != value) {
                    nums[index] = value; // updated the value

                    if (index == 0) {
                        prefixProduct[index] = nums[index] % k;

                        modCount[index] = new int[k];
                        modCount[index][prefixProduct[index++]]++;

                    }

                    for (int i = index; i < N; i++) {
                        prefixProduct[i] = (nums[i] * prefixProduct[i - 1]) % k;

                        modCount[i] = modCount[i - 1].clone();
                        modCount[i][prefixProduct[i]]++;
                    }
                }

                int val = modCount[N - 1][xi] - (start - 1 >= 0 ? modCount[start - 1][xi] : 0);
                result[idx++] = val;
            }


            return result;
        }
    }

}
