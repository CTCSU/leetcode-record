/*
 * @lc app=leetcode.cn id=769 lang=java
 * @lcpr version=30102
 *
 * [769] Max Chunks To Make Sorted
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int currentMax = 0;
        for (int i = 0; i < arr.length; i++) {
            currentMax = Math.max(currentMax, arr[i]);
            if (currentMax == i) {
                count++;
            }
        }

        return count;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4,3,2,1,0]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,0,2,3,4]\n
 * // @lcpr case=end
 * 
 */
