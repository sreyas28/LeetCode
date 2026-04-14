import java.util.*;

public class ProblemNo2463 {
    public static void main(String[] args) {

    }

    class Solution {
        private List<Integer> robot;
        private List<Integer> facPositions;

        public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
            Collections.sort(robot);
            Arrays.sort(factory, Comparator.comparingInt(o -> o[0]));

            this.robot = new ArrayList<>(robot);
            facPositions = new ArrayList<>();

            for(int[] fac: factory) {
                for(int i = 0; i < fac[1]; i++) facPositions.add(fac[0]);
            }

            Long[][] DP = new Long[robot.size() + 1][facPositions.size() + 1];

            return minDis(0,0, DP);
        }

        private long minDis(int roboIdx, int facIdx,  Long[][] DP) {
            if (roboIdx == robot.size()) return 0;
            if  (facIdx == facPositions.size()) return (long) 1e12; // it should be greater than 2 X 10^11

            if (DP[roboIdx][facIdx] != null) return DP[roboIdx][facIdx];

            long selected = Math.abs(robot.get(roboIdx) - facPositions.get(facIdx)) + minDis(roboIdx+1, facIdx+1, DP);
            long notSelected = minDis(roboIdx, facIdx+1, DP);

            DP[roboIdx][facIdx] = Math.min(selected, notSelected);

            return  DP[roboIdx][facIdx];
        }

    }

}
