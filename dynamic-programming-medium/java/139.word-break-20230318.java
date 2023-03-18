import java.util.List;

/*
 * @lc app=leetcode.cn id=139 lang=java
 * @lcpr version=21705
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();
        boolean canAccess[] = new boolean[m + 1];
        canAccess[0] = true;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                if (i >= word.length()) {
                    if (s.substring(i - word.length(), i).equals(word)) {
                        canAccess[i] |= canAccess[i - word.length()];
                    }
                }
            }
        }

        return canAccess[m];
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
 * // "leetcode"\n["leet","code"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "applepenapple"\n["apple","pen"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "catsandog"\n["cats","dog","sand","and","cat"]\n
 * // @lcpr case=end
 * 
 */
