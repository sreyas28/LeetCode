public class ProblemNo1716 {
    public static void main(String[] args) {

        ProblemNo1716.Solution a = new ProblemNo1716().new Solution();
        System.out.println(a.totalMoney(20));

    }

    class Solution {
        public int totalMoney(int n) {
            int numberOfWeeks = n / 7;
            int totalMoney = 0;

            for(int i = 0; i<numberOfWeeks; i++)
                totalMoney += (8+(2*i)) * 3 + 4 + i;

            int remainingDayz = n % 7;
            for(int i = 0; i < remainingDayz; i++) totalMoney += numberOfWeeks + i + 1;

            return totalMoney;
        }
    }

}
