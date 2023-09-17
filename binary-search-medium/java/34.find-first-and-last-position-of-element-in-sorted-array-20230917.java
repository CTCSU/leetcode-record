/*
 * @lc app=leetcode.cn id=34 lang=java
 * @lcpr version=21913
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int r = binarySearch(nums, target, true);
        if (r >= 0 && nums[r] == target) {
            return new int[] { binarySearch(nums, target, false) + 1, r };
        }

        return new int[] { -1, -1 };

    }

    private int binarySearch(int[] nums, int target, boolean needLow) {
        int l = 0, r = nums.length - 1;
        int result = r;
        while (l <= r) {
            int mid = l + (int) Math.floor((r - l) / 2);
            if (nums[mid] < target || (nums[mid] <= target && needLow)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
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
