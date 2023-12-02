import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=300 lang=java
 * @lcpr version=30109
 *
 * [300] Longest Increasing Subsequence
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sortedArray = new ArrayList<>();
        sortedArray.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > sortedArray.get(sortedArray.size() - 1)) {
                sortedArray.add(nums[i]);
            } else {
                updateArray(sortedArray, nums[i]);
            }
        }

        return sortedArray.size();

    }

    private void updateArray(List<Integer> sortedArray, int i) {
        int l = 0, r = sortedArray.size() - 1;
        int result = r;
        while (l <= r) {
            int mid = l + (int) Math.round((r - l) / 2);
            int value = sortedArray.get(mid);
            if (value >= i) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        sortedArray.set(result, i);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [10,9,2,5,3,7,101,18]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,1,0,3,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [7,7,7,7,7,7,7]\n
 * // @lcpr case=end
 * 
 */
