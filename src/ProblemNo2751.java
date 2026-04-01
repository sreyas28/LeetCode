import java.util.*;

public class ProblemNo2751 {
    public static void main(String[] args) {

        ProblemNo2751.Solution a = new ProblemNo2751().new Solution();
//        System.out.println(a.survivedRobotsHealths(new int[]{5,4,3,2,1}, new int[]{2,17,9,15,10}, "RRRRR"));
//        System.out.println(a.survivedRobotsHealths(new int[]{3, 5, 2, 6}, new int[]{10, 10, 15, 12}, "RLRL"));
        System.out.println(a.survivedRobotsHealths(new int[]{3,2,30,24,38,7}, new int[]{42,12,49,11,47,38}, "RRLRRR"));

    }

    class Solution {

        class Robo {
            int givenPos;
            int health;
            char direction;

            Robo(int givenPos, int health, char direction) {
                this.givenPos = givenPos;
                this.health = health;
                this.direction = direction;
            }
        }

        public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
            Map<Integer, Robo> robots = new TreeMap<>();
            for (int i = 0; i < positions.length; i++) robots.put(positions[i], new Robo(i, healths[i], directions.charAt(i)));

            Stack<Robo> stack = new Stack<>();
            List<Robo> tempRes = new ArrayList<>();

            for (int key : robots.keySet()) {
                Robo current = robots.get(key);

                if (current.direction == 'R') {
                    stack.push(current);
                    continue;
                }

                boolean leftRunner = true;
                while (!stack.isEmpty()) {
                    Robo older = stack.pop();

                    if (older.health > current.health) {
                        older.health -= 1;
                        stack.push(older); // adding Right one again
                        leftRunner = false;
                        break;
                    }
                    else if (older.health < current.health) current.health -= 1; // not adding anything because it can remove another one from the stack
                    else {
                        leftRunner = false;
                        break;
                    } // as both cant be added
                }

                if (leftRunner) tempRes.add(current);
            }

            return sorter(tempRes, stack);
        }

        private List<Integer> sorter(List<Robo> tempRes, Stack<Robo> stack) {
            while (!stack.isEmpty()) {
                tempRes.add(stack.pop());
            }

            tempRes.sort( (a,b) -> a.givenPos - b.givenPos);

            List<Integer> res = new ArrayList<>();
            for (Robo tempRe : tempRes) res.add(tempRe.health);

            return res;
        }
    }
}
