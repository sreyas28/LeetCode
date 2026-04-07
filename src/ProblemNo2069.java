import java.util.*;

public class ProblemNo2069 {
    public static void main(String[] args) {

        ProblemNo2069.Robot p = new ProblemNo2069().new Robot(6, 3);

        p.step(2);
        p.step(2);
        System.out.println(Arrays.toString(p.getPos()));
        System.out.println(p.getDir());
        p.step(2);
        p.step(1);
        p.step(4);
        System.out.println(Arrays.toString(p.getPos()));
        System.out.println(p.getDir());


    }

    class Robot {
        private final String[] directions = {"East", "North", "West", "South"};
        private int idx = 0;
        private boolean moved = false;

        private final List<int[]> pos = new ArrayList<>();
        private final List<Integer> dir = new ArrayList<>();

        public Robot(int width, int height) {
            for (int i = 0; i < width ; i++){
                pos.add(new int[] {i,0});
                dir.add(0);
            }
            for  (int i = 1; i < height; i++){
                pos.add(new int[] {width-1,i});
                dir.add(1);
            }
            for(int i = width - 2; i >= 0; i--){
                pos.add(new int[] {i,height-1});
                dir.add(2);
            }
            for(int i = height - 2; i > 0; i--){
                pos.add(new int[] {0,i});
                dir.add(3);
            }
            dir.set(0,3);
        }

        public void step(int num) {
            moved = true;
            idx = (idx + num) % pos.size();
        }

        public int[] getPos() {
            return pos.get(idx);
        }

        public String getDir() {
            if (!moved) return "East";
            return directions[dir.get(idx)];
        }
    }


}
