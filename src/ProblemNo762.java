import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProblemNo762 {

    class Solution {
        public int countPrimeSetBits(int left, int right) {
            Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23));

            int count = 0;
            for(int i = left; i <= right; i++) {
                if (primes.contains(Integer.bitCount(i))) count++;
            }

            return count;
        }
    }

}
