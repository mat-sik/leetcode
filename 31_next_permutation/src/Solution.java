import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,7,5,4,3,2,2,1};
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
        if (nextBiggerIdx < 0) {
            Arrays.sort(nums);
            return;
        }
        swap(nums, rootIdx, nextBiggerIdx);
        reverseFrom(nums, rootIdx + 1);
    }

    public static void reverseFrom(int[] nums, int idx) {
        int length = nums.length - idx;
        for (int i = 0; i < length / 2; i++) {
            int first = idx + i;
            int second = nums.length - 1 - i;
            swap(nums, first, second);
        }
    }

    public static void swap(int[] nums, int firstIdx, int secondIdx) {
        int tmp = nums[firstIdx];
        nums[firstIdx] = nums[secondIdx];
        nums[secondIdx] = tmp;
    }

    public static int findNextBigger(int[] nums, int idx) {
        int root = nums[idx];

        int i = nums.length - 1;
        while (i > idx && nums[i] <= root) {
            i--;
        }

        if (nums[i] <= root) {
            return -1;
        }
        return i;
    }

    public static int findRoot(int[] nums) {
        int i = nums.length - 1;
        int j = i - 1;

        while (j > 0 && nums[i] <= nums[j]) {
            i--;
            j--;
        }

        if (j == 0 && nums[j] >= nums[i]) {
            return -1;
        }

        return j;
    }
}