/*
 * @lc app=leetcode.cn id=10 lang=java
 * @lcpr version=21801
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] matched = new boolean[m + 1][n + 1];
        matched[0][0] = true;
        for (int i = 2; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                matched[0][i] = matched[0][i - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    matched[i][j] = matched[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        matched[i][j] = matched[i][j - 2] || matched[i - 1][j];
                    } else {
                        matched[i][j] = matched[i][j - 2];
                    }
                }
            }
        }

        return matched[m][n];

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
 * // "aa"\n"a"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "aa"\n"a*"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "ab"\n".*"\n
 * // @lcpr case=end
 * 
 */
