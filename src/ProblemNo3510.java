import java.util.*;

public class ProblemNo3510 {
    public static void main(String[] args) {

        ProblemNo3510.Solution p = new ProblemNo3510().new Solution();
        System.out.println(p.minimumPairRemoval(new int[]{5, 3, 2, 4}));
        System.out.println(p.minimumPairRemoval(new int[]{5, 2, 3, 1}));

    }

    class Solution {

        private class Pair implements Comparable<Pair> {
            long sum;
            int index;

            public Pair(long sum, int index) {
                this.sum = sum;
                this.index = index;
            }

            @Override
            public int compareTo(Pair o) {
                if (o.sum == this.sum) return Integer.compare(this.index, o.index);
                return Long.compare(this.sum, o.sum);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pair pair = (Pair) o;
                return sum == pair.sum && index == pair.index;
            }

            @Override
            public int hashCode() {
                return Objects.hash(sum, index);
            }

        }

        public int minimumPairRemoval(int[] nums) {

            int[] prevIndex = new int[nums.length];
            int[] nextIndex = new int[nums.length];
            long[] temp = new long[nums.length];

            TreeSet<Pair> set = new TreeSet<>();
            int badPair = 0;

            for (int i = 0; i < nums.length; i++) {
                prevIndex[i] = i - 1;
                nextIndex[i] = i + 1;
                temp[i] = nums[i];

                if (i + 1 < nums.length) {
                    if (nums[i] > nums[i + 1]) badPair++;

                    Pair pair = new Pair(nums[i] + nums[i + 1], i);
                    set.add(pair);
                }
            }

            System.out.println(Arrays.toString(prevIndex));
            System.out.println(Arrays.toString(nextIndex));
            System.out.println(badPair);

            int count = 0;
            while (badPair > 0) {
                Pair curr = set.first(); // getting the smallest sum
                set.remove(curr); // removed the same from the set


                int first = curr.index; // first value {a,b} here a
                int second = nextIndex[first]; // second value {a,b} here b
                long sum = temp[first] + temp[second];

                int first_left = prevIndex[first]; // left of a
                int second_right = nextIndex[second]; // right of second

                if (temp[first] > temp[second]) badPair--; // as we are going to remove it

                // checking the left side
                if(first_left >= 0){
                    if (temp[first_left] > temp[first] && temp[first_left] <= sum) badPair--;
                    if (temp[first_left] <= temp[first] && temp[first_left] > sum) badPair++;
                    set.remove(new Pair(temp[first] + temp[first_left], first_left));
                    set.add(new Pair(sum + temp[first_left], first_left));
                }

                // checking the right side
                if(second_right < temp.length){
                    if (temp[second] <= temp[second_right] && sum > temp[second_right] ) badPair++;
                    if (temp[second] > temp[second_right] && sum <= temp[second_right]) badPair--;
                    set.remove(new Pair(temp[second] + temp[second_right], second));
                    set.add(new Pair(sum + temp[second_right], first));
                    prevIndex[second_right] = first;
                }

                temp[first] = sum;
                nextIndex[first] = second_right;

                count++;

            }

            return count;
        }
    }

}
