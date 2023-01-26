import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=34 lang=java
 * @lcpr version=21201
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    // public static void main(String[] args) {
    // Solutiond d = new Solutiond();
    // System.out.println(d.searchRange(new int[] { 2, 2 }, 3));
    // }

    public int[] searchRange(int[] nums, int target) {
        int low = binarSearch(nums, target, false) + 1;
        if (low > nums.length - 1 || nums[low] != target) {
            return new int[] { -1, -1 };
        }
        return new int[] { low, binarSearch(nums, target, true) };

    }

    private int binarSearch(int[] nums, int target, boolean low) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target || (low && nums[mid] == target)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // [5,7,7,8,8,10]\n8\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,7,7,8,8,10]\n6\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n0\n
 * // @lcpr case=end
 * 
 */
