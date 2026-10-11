public class ProblemNo3223 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3223().new Solution();
        System.out.println(a.minimumLength("abaacbcbb"));

    }

    class Solution {
        public int minimumLength(String s) {
            int[] characters = new int[26];
            for (char c : s.toCharArray()) characters[c - 'a']++;

            int left = 0;
            for (int i : characters) {
                if (i <= 2) left += i;
                else left += i % 2 == 0 ? 2 : 1;
            }

            return left;
        }
    }

}
