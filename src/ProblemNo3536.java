public class ProblemNo3536 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxProduct(int n) {
            int secondLargest = 0, largest = 0;

            while (n>0){
                int temp = n % 10;
                n /= 10;

                if (temp > largest) {
                    secondLargest = largest;
                    largest = temp;
                }
                else if (temp > secondLargest){
                    secondLargest = temp;
                }
            }

            return secondLargest * largest;
        }
    }
}
