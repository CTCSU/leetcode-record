/*
 * @lc app=leetcode.cn id=769 lang=java
 * @lcpr version=21914
 *
 * [769] Max Chunks To Make Sorted
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {

        int result = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i)
                result++;
        }

        return result;

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
