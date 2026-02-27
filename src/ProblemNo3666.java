import java.util.*;

public class ProblemNo3666 {
    public static void main(String[] args) {

        ProblemNo3666.Solution p = new ProblemNo3666().new Solution();
        System.out.println(p.minOperations("0101", 3));

    }

    // someOne else Solution But Great Solution 🤓🤓🤓
    class Solution {
        public int minOperations(String s, int k) {
            int zero = 0;
            int len = s.length();

            for (int i = 0; i < len; i++)
                zero += ~s.charAt(i) & 1;

            if (zero == 0)
                return 0;

            if (len == k)
                return (zero == len ? 1 : -1);

            int base = len - k;

            int odd = Math.max(
                    (zero + k - 1) / k,
                    (len - zero + base - 1) / base
            );

            odd += ~odd & 1;

            int even = Math.max(
                    (zero + k - 1) / k,
                    (zero + base - 1) / base
            );

            even += even & 1;

            int res = Integer.MAX_VALUE;

            if ((k & 1) == (zero & 1))
                res = Math.min(res, odd);

            if ((~zero & 1) == 1)
                res = Math.min(res, even);

            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

    // still TLE
    class Solution__ {
        public int minOperations(String s, int k) {
            int n = s.length();
            int zeroes = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') zeroes++;
            }

            Queue<int[]> queue = new ArrayDeque<>(); // zero and operations
            boolean[] visited = new boolean[n + 1];

            queue.offer(new int[]{zeroes, 0});
            visited[zeroes] = true;

            while (!queue.isEmpty()) {
                int[]  cur = queue.poll();
                int z = cur[0], operations = cur[1];
                if (z == 0) return operations;

                for ( int oneToConvert = 0; oneToConvert <= Math.min(k, n - z); oneToConvert++ ) {
                    int zeroToConvert = k -  oneToConvert;
                    if (zeroToConvert > z) continue;

                    int newZeroes = z - zeroToConvert + oneToConvert;
                    if (!visited[newZeroes]) {
                        queue.offer(new int[]{newZeroes, operations + 1});
                        visited[newZeroes] = true;
                    }
                }
            }

            return -1;
        }
    }

    // cleaner but Costly
    class Solution_ {

        class DataType {
            int zeroes = 0;
            int ones = 0;
            int level = 0;

            DataType(int zeroes, int ones, int level) {
                this.zeroes = zeroes;
                this.ones = ones;
                this.level = level;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                DataType dataType = (DataType) o;
                return zeroes == dataType.zeroes && ones == dataType.ones;
            }

            @Override
            public int hashCode() {
                return Objects.hash(zeroes, ones);
            }

        }

        public int minOperations(String s, int k) {
            DataType start = new DataType(0, 0, 0);
            for (char c : s.toCharArray()) {
                if (c == '1') start.ones++;
                else start.zeroes++;
            }

            Queue<DataType> global = new LinkedList<>();
            Set<DataType> visited = new HashSet<>();
            global.offer(start);
            visited.add(start);

            while (!global.isEmpty()) {
                DataType curr = global.poll();
                if (curr.zeroes == 0) return curr.level;

                for (int oneToConvert = 0; oneToConvert <= Math.min(k, curr.ones); oneToConvert++) {
                    int zeroToConvert = k - oneToConvert;
                    if (zeroToConvert > curr.zeroes) continue;

                    int newOnes = curr.ones - oneToConvert + zeroToConvert;
                    int newZeroes = curr.zeroes - zeroToConvert + oneToConvert;

                    DataType temp = new DataType(newZeroes, newOnes, curr.level + 1);
                    if (!visited.contains(temp)) {
                        visited.add(temp);
                        global.offer(temp);
                    }
                }
            }

            return -1;
        }
    }

}
