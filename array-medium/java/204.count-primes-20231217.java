import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=204 lang=java
 * @lcpr version=30112
 *
 * [204] Count Primes
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        Boolean[] notPrime = new Boolean[n];
        Arrays.fill(notPrime, false);
        notPrime[0] = true;
        notPrime[1] = true;

        for (int i = 2; i * i < n; i++) {
            if (!notPrime[i]) {
                for (int j = i; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return (int) Arrays.stream(notPrime).filter(t -> !t).count();

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 10\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 0\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 1\n
 * // @lcpr case=end
 * 
 */
