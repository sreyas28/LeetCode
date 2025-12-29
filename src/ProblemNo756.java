import java.util.*;

public class ProblemNo756 {
    public static void main(String[] args) {
        List<String> allowed = new ArrayList<>();
        allowed.add("AAB");
        allowed.add("AAC");


        ProblemNo756.Solution p = new ProblemNo756().new Solution();
        System.out.println(p.pyramidTransition("AAA", allowed));

    }

    class Solution {
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            Map<String, List<Character>> baseTop= new HashMap<>();
            for(String s: allowed){
                baseTop.computeIfAbsent(s.substring(0,2),  k -> new ArrayList<>()).add(s.charAt(2));
            }

            return solver(bottom,"", baseTop,0);
        }

        private boolean solver(String base, String nextBase, Map<String, List<Character>> baseTop, int index) {
            if(base.length() == 1) return true;

            if(index == base.length()-1){
                return solver(nextBase, "",  baseTop, 0);
            }
            else{
                String key = base.charAt(index) +""+ base.charAt(index+1);

                if(baseTop.containsKey(key)){
                    for(char c: baseTop.get(key)){
                        if(solver(base,nextBase + c,baseTop,index+1)) return true;
                    }
                }
                else return false;
            }
            return false;
        }

    }


}
