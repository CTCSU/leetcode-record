import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=204 lang=java
 * @lcpr version=21505
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
                if ((long) i * i < n) {
                    for (int j = i * i; j > 0 && j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }

        return count;
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
