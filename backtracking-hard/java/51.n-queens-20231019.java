import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @lc app=leetcode.cn id=51 lang=java
 * @lcpr version=30102
 *
 * [51] N-Queens
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        String[][] currentResult = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(currentResult[i], ".");
        }
        boolean[] column = new boolean[n];
        boolean[] xAxis = new boolean[2 * n];
        boolean[] yAxis = new boolean[2 * n];

        backTracing(n, -1, column, xAxis, yAxis, currentResult, result);

        return result;

    }

    private void backTracing(int n, int currentRow, boolean[] column, boolean[] xAxis, boolean[] yAxis,
            String[][] currentResult, List<List<String>> result) {

        currentRow++;
        for (int i = 0; i < n; i++) {
            int xAxisValue = currentRow + i;
            int yAxisValue = n + currentRow - i;
            if (!column[i] && !xAxis[xAxisValue] && !yAxis[yAxisValue]) {
                column[i] = true;
                xAxis[xAxisValue] = true;
                yAxis[yAxisValue] = true;
                currentResult[currentRow][i] = "Q";
                if (currentRow == n - 1) {
                    result.add(generateResult(currentResult));
                } else {
                    backTracing(n, currentRow, column, xAxis, yAxis, currentResult, result);
                }
                column[i] = false;
                xAxis[xAxisValue] = false;
                yAxis[yAxisValue] = false;
                currentResult[currentRow][i] = ".";
            }
        }
    }

    private List<String> generateResult(String[][] currentResult) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < currentResult.length; i++) {
            result.add(Stream.of(currentResult[i]).collect(Collectors.joining()));

        }

        return result;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 1\n
 * // @lcpr case=end
 * 
 */
