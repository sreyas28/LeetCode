public class ProblemNo788 {
    public static void main(String[] args) {

        Solution p = new ProblemNo788().new Solution();
        System.out.println(p.rotatedDigits(10));

    }

    class Solution {
        public int rotatedDigits(int n) {

            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (checker(i)) count++;
            }

            return count;
        }

        private boolean checker(int original){
            int itr = 0;

            int number = original;
            int newNumber = 0;

            while(number > 0){
                int current = number % 10;

                switch (current){
                    case 0, 1, 8:
                        newNumber = (int) (current * Math.pow(10,itr)) + newNumber;
                        break;

                    case 2:
                        newNumber = (int) (5 * Math.pow(10,itr)) + newNumber;
                        break;
                    case 5:
                        newNumber = (int) (2 * Math.pow(10,itr)) + newNumber;
                        break;

                    case 6:
                        newNumber = (int) (9 * Math.pow(10,itr)) + newNumber;
                        break;
                    case 9:
                        newNumber = (int) (6 * Math.pow(10,itr)) + newNumber;
                        break;

                    default:
                        return false;
                }


                itr++;
                number = number / 10;
            }

            return newNumber != original;
        }

    }

}
