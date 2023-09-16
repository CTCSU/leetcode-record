/*
 * @lc app=leetcode.cn id=474 lang=java
 * @lcpr version=21913
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] numberCount = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            Integer oneCount = 0, zeroCount = 0;
            for (char currentC : strs[i].toCharArray()) {
                if (currentC == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            numberCount[i][0] = zeroCount;
            numberCount[i][1] = oneCount;
        }

        int[][] dynamic = new int[m + 1][n + 1];
        for (int i = 0; i < numberCount.length; i++) {
            int zeroCount = numberCount[i][0], oneCount = numberCount[i][1];
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j >= zeroCount && k >= oneCount) {
                        dynamic[j][k] = Math.max(dynamic[j][k], dynamic[j - zeroCount][k - oneCount] + 1);
                    }
                }
            }
        }

        return dynamic[m][n];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // ["10","0001","111001","1","0"]\n5\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["10","0","1"]\n1\n1\n
 * // @lcpr case=end
 * 
 */
