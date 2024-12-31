import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 7, 5, 4, 3, 2, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.stream(nums).boxed().toList());
    }

    public static void nextPermutation(int[] nums) {
        int rootIdx = findRoot(nums);
        if (rootIdx < 0) {
            Arrays.sort(nums);
            return;
        }
        int nextBiggerIdx = findNextBigger(nums, rootIdx);
        swap(nums, rootIdx, nextBiggerIdx);
        reverseFrom(nums, rootIdx + 1);
    }

    public static void reverseFrom(int[] nums, int idx) {
        int left = idx;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void swap(int[] nums, int firstIdx, int secondIdx) {
        int tmp = nums[firstIdx];
        nums[firstIdx] = nums[secondIdx];
        nums[secondIdx] = tmp;
    }

    public static int findNextBigger(int[] nums, int rootIdx) {
        for (int i = nums.length - 1; i > rootIdx; i--) {
            if (nums[i] > nums[rootIdx]) {
                return i;
            }
        }
        return -1;
    }

    public static int findRoot(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                return i;
            }
        }
        return -1;

    }
}