import java.lang.foreign.StructLayout;
import java.util.*;

public class ProblemNo955 {
    public static void main(String[] args) {

        ProblemNo955.Solution a = new ProblemNo955().new Solution();
        System.out.println(a.minDeletionSize(new String[]{"xc","yb","za"}));
        System.out.println(a.minDeletionSize(new String[]{"zyx","wvu","tsr"}));
        System.out.println(a.minDeletionSize(new String[]{"xga","xfb","yfa"}));

    }

    class Solution {
        public int minDeletionSize(String[] strs) {
            int len = strs[0].length();
            int delete = 0;
            boolean[] fixed = new boolean[strs.length];

            for(int i=0; i<len; i++){
                boolean flag = false;

                for(int j = 0; j < strs.length-1; j++){
                    if(!fixed[j] && strs[j].charAt(i) > strs[j+1].charAt(i)){
                        flag = true;
                        break;
                    }
                }

                if(flag) {
                    delete++;
                    continue;
                }

                for(int j = 0; j < strs.length-1; j++){
                    if(!fixed[j] && strs[j].charAt(i) < strs[j+1].charAt(i)){
                        fixed[j] = true;
                    }
                }
            }

            return delete;
        }
    }

}
