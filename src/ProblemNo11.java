import java.util.HashMap;

public class ProblemNo11 {
    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int temp = Math.min(height[i], height[j]) * (j-i);
                if (temp > max) {
                    max = temp;
                }
            }
        }

        return max;
    }

    public static int maxArea2(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return max;
    }
}
