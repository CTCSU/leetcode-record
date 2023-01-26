// /*
// * @lc app=leetcode.cn id=221 lang=java
// *
// * [221] 最大正方形
// */

// // @lc code=start
// class Solution {
// public int maximalSquare(char[][] matrix) {

// int m, n;
// m = matrix.length;
// n = matrix[0].length;
// int[][] array = new int[m][n];

// int max = 0;

// for (int i = 0; i < m; i++) {
// for (int j = 0; j < n; j++) {
// if (matrix[i][j] == '1') {
// if (i == 0 || 0 == j) {
// array[i][j] = 1;
// } else {
// array[i][j] = getMin(array[i][j - 1], array[i - 1][j], array[i - 1][j - 1]) +
// 1;
// }
// max = Math.max(max, array[i][j]);
// }
// }
// }

// return max * max;
// }

// private int getMin(int... value) {
// if (value.length == 0) {
// return 0;
// }
// int min = value[0];
// for (int i = 0; i < value.length; i++) {
// if (min > value[i]) {
// min = value[i];
// }
// }

// return min;

// }

// }

// // @lc code=end
