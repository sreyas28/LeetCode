import java.util.ArrayList;

public class ProblemNo1622 {
    public static void main(String[] args) {
        ProblemNo1622.Fancy fancy = new ProblemNo1622().new Fancy();

        fancy.append(2);
        fancy.addAll(3);
        fancy.append(7);
        fancy.multAll(2);
        fancy.getIndex(0);
        fancy.addAll(3);
        fancy.append(10);
        fancy.multAll(2);
        fancy.getIndex(0);
        fancy.getIndex(1);
        fancy.getIndex(2);

    }

    class Fancy {
        private ArrayList<Long> list;
        private long add, mul;
        private final long MOD =  1000000007;

        public Fancy() {
            list = new ArrayList<>();
            add = 0;
            mul = 1;
        }

        public void append(int val) {
            long normalized = (val - add % MOD + MOD) % MOD * modInverse(mul) % MOD;
            list.add(normalized);
        }

        public void addAll(int inc) {
            add = (add + inc) % MOD;
        }

        public void multAll(int m) {
            mul = (mul * m) % MOD;
            add = (add * m) % MOD;
        }

        public int getIndex(int idx) {
            if (idx >= list.size()) return -1;
            return (int) ((list.get(idx) * mul + add) % MOD);
        }

        private long modInverse(long base) {
            long result = 1;

            base %= MOD;
            long mod = MOD - 2;

            while (mod > 0) {
                if ((mod & 1) == 1) result = (result * base) % MOD;
                base = (base * base) % MOD;
                mod >>= 1;
            }

            return result;
        }

    }

    // Brute Force
    class Fancy_ {
        private final long[] list;
        private int index;
        private final int MOD = 1_000_000_007;

        public Fancy_() {
            list = new long[100000];
            this.index = 0;
        }

        public void append(int val) {
            list[index++] = val;
        }

        public void addAll(int inc) {
            for (int i = 0; i < index; i++) {
                list[i] = (list[i] + inc) % MOD;
            }
        }

        public void multAll(int m) {
            for (int i = 0; i < index; i++) {
                list[i] = (list[i] * m) % MOD;
            }
        }

        public int getIndex(int idx) {
            if (idx >= index) {
                return -1;
            }

            return Math.toIntExact(list[idx] % MOD);
        }
    }

}
