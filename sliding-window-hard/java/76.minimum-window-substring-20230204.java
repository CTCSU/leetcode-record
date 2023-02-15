import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=76 lang=java
 * @lcpr version=21401
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int needMatch = 0;
        Map<Character, Integer> needMap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (needMap.containsKey(c)) {
                needMap.put(c, needMap.get(c) + 1);
            } else {
                needMatch++;
                needMap.put(c, 1);
            }
        }

        int l = 0, r = 0;
        int lIndex = 0, len = Integer.MAX_VALUE;
        while (r < s.length()) {
            if (needMap.containsKey(s.charAt(r))) {
                char rc = s.charAt(r);
                Integer value = needMap.put(rc, needMap.get(rc) - 1) - 1;
                if (value == 0) {
                    needMatch--;
                }
            }

            while (needMatch == 0 && l <= r) {
                char lc = s.charAt(l);
                if (needMap.containsKey(lc)) {
                    Integer value = needMap.put(lc, needMap.get(lc) + 1);
                    if (value == 0) {
                        needMatch++;
                        if(r - l < len) {
                            lIndex = l;
                            len = r - l;
                        }
                    }
                }
                l++;
            }

            r++;
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(lIndex, lIndex + len + 1);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "ADOBECODEBANC"\n"ABC"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "a"\n"a"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "a"\n"aa"\n
 * // @lcpr case=end
 * 
 */
