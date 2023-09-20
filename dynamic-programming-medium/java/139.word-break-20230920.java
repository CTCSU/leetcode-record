/*
 * @lc app=leetcode.cn id=139 lang=java
 * @lcpr version=21914
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] ableSplit = new boolean[s.length() + 1];
        ableSplit[0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String curs = wordDict.get(j);
                int curLen = curs.length();
                if (curLen <= i + 1) {
                    if (s.substring(i + 1 - curLen, i + 1).equals(curs)) {
                        ableSplit[i + 1] = ableSplit[i + 1] || ableSplit[i - curLen + 1];
                    }
                }
            }
        }

        return ableSplit[s.length()];

    }
}
// @lc code=end

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
