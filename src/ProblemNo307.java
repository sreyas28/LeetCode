public class ProblemNo307 {
    public static void main(String[] args) {
        ProblemNo307.NumArray p = new ProblemNo307().new NumArray(new int[]{1, 3, 5});

        System.out.println(p.sumRange(0, 2));
        p.update(1, 2);

    }

    class NumArray {
        long[] segmentTree;
        int size;

        public NumArray(int[] nums) {
            this.size = nums.length;
            segmentTree = new long[4 * size];

            segmentTreeMaker(0, 0, size - 1, nums);
        }

        public void update(int index, int val) {
            updater(index, val, 0, 0, size - 1);
        }

        public int sumRange(int left, int right) {
            return rangeQuery(left, right, 0, 0, size - 1);
        }

        private void segmentTreeMaker(int i, int left, int right, int[] nums) {
            if (left == right) {
                segmentTree[i] = nums[left];
                return;
            }

            int mid = (left + right) / 2;

            segmentTreeMaker(2 * i + 1, left, mid, nums);
            segmentTreeMaker(2 * i + 2, mid + 1, right, nums);

            segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
        }

        private void updater(int index, int val, int i, int left, int right) {
            if (left == right) {
                segmentTree[i] = val;
                return;
            }

            int mid = (left + right) / 2;

            if (index <= mid) updater(index, val, 2 * i + 1, left, mid);
            else updater(index, val, 2 * i + 2, mid + 1, right);

            segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
        }

        private int rangeQuery(int rangeLeft, int rangeRight, int i, int left, int right) {
            if (rangeRight < left || rangeLeft > right) return 0;
            else if (rangeLeft <= left && rangeRight >= right) return Math.toIntExact(segmentTree[i]);

            int mid = (left + right) / 2;
            int leftSum = rangeQuery(rangeLeft, rangeRight, 2 * i + 1, left, mid);
            int rightSum = rangeQuery(rangeLeft, rangeRight, 2 * i + 2, mid + 1, right);

            return leftSum + rightSum;
        }
    }

}
