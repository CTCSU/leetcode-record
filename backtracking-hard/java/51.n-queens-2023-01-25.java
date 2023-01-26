import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    // public static void main(String[] args) {
    // Solutiona solutiona = new Solutiona();
    // System.out.println(solutiona.solveNQueens(4));
    // }

    public List<List<String>> solveNQueens(int n) {
        String[][] matrix = new String[n][n];
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ".";
            }
        }

        List<List<String>> result = new ArrayList<>();

        boolean[] column = new boolean[n];
        boolean[] xAxis = new boolean[2 * n];
        boolean[] yAxis = new boolean[2 * n];

        backTracing(result, matrix, column, xAxis, yAxis, 0, n);

        return result;
    }

    private void backTracing(List<List<String>> result, String[][] matrix, boolean[] column, boolean[] xAxis,
            boolean[] yAxis, int i, int n) {
        if (i == n) {
            result.add(generateResult(matrix));
            return;
        }

        for (int j = 0; j < n; j++) {
            int x = i + j, y = n + i - j;
            if (!column[j] && !xAxis[x] && !yAxis[y]) {
                column[j] = xAxis[x] = yAxis[y] = true;
                matrix[i][j] = "Q";
                backTracing(result, matrix, column, xAxis, yAxis, i + 1, n);
                matrix[i][j] = ".";
                column[j] = xAxis[x] = yAxis[y] = false;
            }
        }
    }

    private List<String> generateResult(String[][] matrix) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            result.add(Stream.of(matrix[i]).collect(Collectors.joining()));
        }

        return result;
    }

}
// @lc code=end
