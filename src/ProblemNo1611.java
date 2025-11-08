import java.util.*;

public class ProblemNo1611 {
    public static void main(String[] args) {


        ProblemNo1611.Solution a = new ProblemNo1611().new Solution();
        System.out.println(a.minimumOneBitOperations((int) 3));

    }

    class Solution {

        public int minimumOneBitOperations(int n) {

            int[] function = new int[32];
            for(int i = 1; i<32; i++) function[i] = function[i-1]*2 + 1;

            int result = 0, sign = 1;

            for(int i = 30; i >= 0; i--){

                int ithbit = ((1 << i) & n);
                if(ithbit == 0) continue;

                result = result + sign*function[i+1];

                sign *= -1;
            }

            return result;
        }
    }

    class Solution__ {

        public int minimumOneBitOperations(int n) {
            Map<Integer, Integer> valMap = new HashMap<>();

            int powerOf2 = 1;
            valMap.put(1,1);

            while((powerOf2 << 1) <= n){
                int temp = powerOf2 << 1;

                valMap.put(temp, valMap.get(powerOf2) * 2 + 1);
                powerOf2 = temp;
            }


            int result = 0, sign = (Integer.bitCount(n) % 2 == 0) ? -1: 1, x = 0;

            while(n > 0){
                if(n % 2 == 1){
                    result = result + sign*valMap.get((int)Math.pow(2, x));
                    sign *= -1;
                }

                n /= 2;
                x++;
            }

            return result;
        }
    }

    class Solution_ {

        private int Operations = 0;

        public int minimumOneBitOperations(int n) {
            if(n == 0) return 0;
            else if(n == 1) return 1;

            int[] binary = binaryConversion(n);

            System.out.println(Arrays.toString(binary));
            for(int i = 0; i<binary.length ; i++){
                if(binary[i] == 1) {
                    bitZeroMaker(i, binary, 0);
                    System.out.println(Arrays.toString(binary) + " " + Operations);
                }
            }

            return Operations;
        }

        private int[] binaryConversion(int n){
            int size = (int) (Math.log(n)/Math.log(2)) + 1;

            int[] binary = new int[size];

            while(n != 0){
                size -= 1;
                binary[size] = n % 2;
                n /=2;
            }
            return binary;
        }

        private void bitZeroMaker(int i, int[] binary, int toMake){
            if(i == binary.length - 1) {
                if(toMake != binary[i]) {
                    binary[binary.length - 1] ^= 1;
                    Operations++;
                }
            }
            else{
                if(toMake == 1 && binary[i] == 1) bitZeroMaker(i+1, binary, 0);
                else bitZeroMaker(i + 1, binary, 1);

                if(binary[i] != toMake) Operations++;
                binary[i] = toMake;

                if(toMake == 1) {
                    for (int makeZero = i + 1; makeZero < binary.length; makeZero++) {
                        if (binary[makeZero] != 0)
                            bitZeroMaker(makeZero, binary, 0);
                    }
                }

            }
        }
    }
}
