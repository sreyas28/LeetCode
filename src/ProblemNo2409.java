public class ProblemNo2409 {

    public static void main(String[] args) {

    }

    class Solution {

        private final static int[] MONTH_SUM = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

            int aliceArrived = MONTH_SUM[(Integer.parseInt(arriveAlice.substring(0, 2)) - 1)] + Integer.parseInt(arriveAlice.substring(3, 5));
            int bobArrived = MONTH_SUM[(Integer.parseInt(arriveBob.substring(0, 2)) - 1)] + Integer.parseInt(arriveBob.substring(3, 5));

            int aliceLeave = MONTH_SUM[(Integer.parseInt(leaveAlice.substring(0, 2)) - 1)] + Integer.parseInt(leaveAlice.substring(3, 5));
            int bobLeave = MONTH_SUM[(Integer.parseInt(leaveBob.substring(0, 2)) - 1)] + Integer.parseInt(leaveBob.substring(3, 5));

            int res = Math.min(aliceLeave, bobLeave) - Math.max(aliceArrived,  bobArrived) + 1;

            return Math.max(res, 0);
        }
    }

}
