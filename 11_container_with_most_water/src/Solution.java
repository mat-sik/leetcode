import static java.lang.Math.min;

public class Solution {

    public static int calcArea(int[] height, int i, int j) {

        int iHeight = height[i];
        int jHeight = height[j];

        int minHeight = min(iHeight, jHeight);
        int distance = j - i;

        return minHeight * distance;
    }

    public static int maxAreaNaive(int[] height) {

        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = calcArea(height, i, j);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static int maxArea(int[] height) {

        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = calcArea(height, left, right);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] > height[right]) {
                right--;
            } else if(height[left] < height[right]) {
                left++;
            } else {
                int distance = right - left;
                int nextLeft = left + 1;
                int nextRight = right - 1;
                if (distance == 1) { // nothing between
                    break;
                } else if (distance == 2) { // one between
                    // chose arbitrary
                    right = nextRight;
                } else { // more than one between
                    if (height[nextLeft] > height[nextRight]) {
                        left = nextLeft;
                    } else {
                        right = nextRight;
                    }
                }
            }
        }

        return maxArea;
    }

    /*          3  |4  |5  |6  |7
                120|4  |3  |120|
                120|4  |4  |120|
                120|4  |3  |4  |120
                120|120|   |
                120|3  |120|
     */

    public static void main(String[] args) {

        var input = new int[]{1, 2, 3, 4, 120, 4, 3, 120, 2};
        maxArea(input);
    }
}