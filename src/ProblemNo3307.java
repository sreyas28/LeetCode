import java.util.HashMap;

public class ProblemNo3307 {
    public static void main(String[] args) {
        ProblemNo3307.Solution a = new ProblemNo3307().new Solution();

        System.out.println(a.kthCharacter(5, new int[]{1,1,1,1}));
    }

    class Solution {
        public char kthCharacter(long k, int[] operations) {
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('a', 1);

            for(int i: operations){
                if(i == 0) map.replaceAll((k1, v) -> map.get(k1) * 2);
                else{
                    HashMap<Character, Integer> mapTemp = new HashMap<>();

                    for(char key: map.keySet()){
                        char newKey = (char)(((key + 1 - 'a') % 26) + 'a');
                        mapTemp.put(newKey, map.get(key));
                    }
                    for(char key: mapTemp.keySet()) map.put(key, map.getOrDefault(key, 0) + mapTemp.get(key));
                }
            }

            System.out.println(map);


            return ' ';
        }
    }

}
