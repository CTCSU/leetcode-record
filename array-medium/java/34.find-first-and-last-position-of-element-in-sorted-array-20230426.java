/*
 * @lc app=leetcode.cn id=34 lang=java
 * @lcpr version=21801
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    private int binarySearch(int[] nums, int target, boolean needHigh) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = Math.round((r - l) / 2) + l;
            if (nums[mid] < target || (needHigh && nums[mid] == target)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int high = binarySearch(nums, target, true);
        if (high == -1 || nums[high] != target) {
            return new int[] { -1, -1 };
        } else {
            int low = binarySearch(nums, target, false) + 1;
            low = low > high ? high : low;
            return new int[] { low, high };
        }

    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

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
