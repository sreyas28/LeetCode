public class ProblemNo3622 {

    class Solution {
        public boolean checkDivisibility(int n) {
            int sum = 0, product = 1, temp = n;

            while(temp > 0){
                int val = temp % 10;
                temp /= 10;

                sum += val;
                product *= val;
            }

            return n % (sum + product)== 0;
        }
    }

}
