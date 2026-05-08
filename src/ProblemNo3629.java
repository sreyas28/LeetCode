import java.util.*;

public class ProblemNo3629 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3629().new Solution();
        System.out.println(a.minJumps(new int[]{2,3,4,7,9}));

    }

    class Solution {
        private static final int LIMIT = 1_000_000;
        private static final List<Integer>[] FACTORS;

        static {
            FACTORS = new ArrayList[LIMIT];

            for (int i = 0; i < LIMIT; i++) FACTORS[i] = new ArrayList<>();
            for (int i = 2; i < LIMIT; i++) {
                if (FACTORS[i].isEmpty()) {
                    for (int j = i; j < LIMIT; j += i) FACTORS[j].add(i);
                }
            }
        }

        public int minJumps(int[] nums) {
            int N = nums.length;

            Map<Integer, List<Integer>> validJumpsMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                for (int p : FACTORS[nums[i]]) {
                    validJumpsMap.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                }
            }

            int count = 0;
            List<Integer> outterList = new ArrayList<>();
            boolean[] visited = new boolean[N];
            outterList.add(0);
            visited[0] = true;

            while (true) {
                List<Integer> innerList = new ArrayList<>();

                for (int currentIndex: outterList) {
                    if (currentIndex == N - 1) return count;

                    if (currentIndex > 0 && !visited[currentIndex-1]) {
                        innerList.add(currentIndex-1);
                        visited[currentIndex-1] = true;
                    }

                    if (currentIndex < N-1 && !visited[currentIndex+1]) {
                        innerList.add(currentIndex+1);
                        visited[currentIndex+1] = true;
                    }

                    if (FACTORS[nums[currentIndex]].size() == 1){
                        for (int validJumpIndex : validJumpsMap.getOrDefault(nums[currentIndex], new ArrayList<>())) {
                            visited[validJumpIndex] = true;
                            innerList.add(validJumpIndex);
                        }
                    }

                    validJumpsMap.remove(nums[currentIndex]);
                }

                outterList = innerList;
                count++;
            }
        }

    }


    // TLE
    class Solution_ {
        private int N;
        private HashMap<Integer, List<Integer>> primesIndexMap;
        private int[] nums;
        private Integer[] DP;

        public int minJumps(int[] nums) {
            this.N = nums.length;
            this.nums = nums;

            this.DP = new Integer[N];

            final Set<Integer> PRIMES = primeNumbers();
            this.primesIndexMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];

                if (PRIMES.contains(num))
                    primesIndexMap.computeIfAbsent(num, k -> new ArrayList<>()).add(i);

                else if (!primesIndexMap.isEmpty()) {
                    for (int prime : primesIndexMap.keySet()) {
                        if (num % prime == 0) primesIndexMap.get(prime).add(i);
                    }
                }
            }

            return solve(0);
        }

        private int solve(int index) {
            if (index == N - 1) return 0;
            if (DP[index] != null) return DP[index];

            int current = nums[index];

            int level = 1 + solve(index + 1); // normal way

            if (primesIndexMap.containsKey(current)) {
                for (int validJump : primesIndexMap.get(current)) {
                    if (validJump > index) level = Math.min(level, 1 + solve(validJump)); // jumping
                }
            }

            DP[index] = level;
            return level;
        }

        private Set<Integer> primeNumbers() {
            Set<Integer> set = new HashSet<>();

            final int limit = 1_000_000;
            boolean[] primes = new boolean[limit + 1];

            Arrays.fill(primes, true);
            primes[0] = false;
            primes[1] = false;

            for (int i = 2; i <= limit; i++) {
                if (!primes[i]) continue;

                int k = i * 2;
                while (k <= limit) {
                    primes[k] = false;
                    k += i;
                }
            }

            for (int i = 2; i <= limit; i++) {
                if (primes[i]) set.add(i);
            }

            return set;
        }
    }

}
