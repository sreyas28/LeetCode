import java.util.Arrays;
import java.util.HashMap;

public class ProblemNo1865 {
    public static void main(String[] args) {
        int[] t = {1, 1, 2, 2, 2, 3};
        int[] m = {1, 4, 5, 2, 5, 4};

        ProblemNo1865.FindSumPairs a = new ProblemNo1865().new FindSumPairs(t, m);

        System.out.println(a.count(7));
        a.add(3,2);
        System.out.println(a.count(8));

    }

    class FindSumPairs {

        private final int[] nums1;
        private final int[] nums2;
        private HashMap<Integer, Integer> cnt;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;

            cnt = new HashMap<>();
            for(int num: nums2) cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        public void add(int index, int val) {
            int old = nums2[index];
            cnt.put(old, cnt.get(old) - 1);

            old += val;

            cnt.put(old, cnt.getOrDefault(old, 0) + 1);
            nums2[index] += val;
        }

        public int count(int tot) {
            int ans = 0;
            for(int num: nums1){
                int find = tot - num;

                ans += cnt.getOrDefault(find, 0);
            }
            return ans;
        }
    }

}
