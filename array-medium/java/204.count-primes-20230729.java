import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=204 lang=java
 * @lcpr version=21912
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        Boolean[] isPrime = new Boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i; i * j < n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        return (int) Arrays.stream(isPrime).filter(t -> t).count();

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
