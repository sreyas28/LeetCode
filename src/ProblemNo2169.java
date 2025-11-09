public class ProblemNo2169 {
    public static void main(String[] args) {

        ProblemNo2169.Solution a = new ProblemNo2169().new Solution();
        System.out.println(a.countOperations(2,3));

    }

    class Solution {
        public int countOperations(int num1, int num2) {
            int operation = 0;

            while(num1 != 0 && num2 != 0){
                if(num1 >= num2) num1 -= num2;
                else num2 -= num1;

                operation++;
            }

            return operation;
        }
    }

}
