public class ProblemNo2211 {
    public static void main(String[] args) {

    }

    class Solution {
        public int countCollisions(String directions) {
            int result = 0, r = 0;
            boolean collision = false;

            for(char c: directions.toCharArray()){

                if(c == 'R'){
                    r++;
                    collision = false;
                }
                else if(c == 'L'){
                    if(collision) result += 1;
                    else if(r != 0){
                        result += r + 1;
                        collision = true;
                        r = 0;
                    }
                }

                else {
                    result += r;
                    collision = true;
                    r = 0;
                }
            }

            return result;
        }
    }
}
