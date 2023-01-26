/*
 * @lc app=leetcode.cn id=81 lang=java
 * @lcpr version=21201
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[l] == nums[mid]) {
                l++;
            } else if (nums[mid] > nums[l]) {
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return false;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,5,6,0,0,1,2]\n0\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,5,6,0,0,1,2]\n3\n
 * // @lcpr case=end
 * 
 */
