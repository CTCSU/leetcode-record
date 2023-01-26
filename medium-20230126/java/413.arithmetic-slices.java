/*
 * @lc app=leetcode.cn id=413 lang=java
 * @lcpr version=21201
 *
 * [413] Arithmetic Slices
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        int accumulated = 0;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i]-nums[i-1] == nums[i-1] - nums[i-2]){
                accumulated++;
                result += accumulated;
            } else {
                accumulated = 0;
            }
            
        }

        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */


