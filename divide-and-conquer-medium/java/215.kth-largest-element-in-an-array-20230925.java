/*
 * @lc app=leetcode.cn id=215 lang=java
 * @lcpr version=21917
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {

        return divideSearch(nums, 0, nums.length - 1, k);

    }

    private int divideSearch(int[] nums, int i, int j, int k) {
        if (i == j) {
            return nums[i];
        }

        int ci = i, cj = j;
        int random = i + (int) (Math.random() * (j - i));
        swap(nums, i, random);

        int iv = nums[i];
        while (ci < cj) {
            if (nums[cj] < iv) {
                cj--;
            } else {
                ci++;
                swap(nums, ci, cj);
            }
        }
        swap(nums, ci, i);

        if (ci == k - 1) {
            return nums[ci];
        } else if (ci > k - 1) {
            return divideSearch(nums, i, ci - 1, k);
        } else {
            return divideSearch(nums, ci + 1, j, k);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,2,1,5,6,4]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,2,3,1,2,4,5,5,6]\n4\n
 * // @lcpr case=end
 * 
 */
