// import java.util.HashMap;
// import java.util.Map;

// /*
// * @lc app=leetcode.cn id=318 lang=java
// *
// * [318] 最大单词长度乘积
// */

// // @lc code=start
// class Solution {
// private Map<String, Integer> wordsMap = new HashMap<>();

// public int maxProduct(String[] words) {
// initMap(words);

// int max = 0;
// for (int i = 0; i < words.length; i++) {
// for (int j = i + 1; j < words.length; j++) {
// int vi = wordsMap.get(words[i]), vj = wordsMap.get(words[j]);
// if ((vi & vj) == 0) {
// max = Math.max(max, words[i].length() * words[j].length());
// }
// }

// }

// return max;
// }

// private void initMap(String[] words) {
// for (String word : words) {
// int value = 0;
// for (int i = 0; i < word.length(); i++) {
// int reduceResult = word.charAt(i) - 'a' + 1;
// value = value | (1 << reduceResult);
// }
// wordsMap.put(word, value);
// }
// }
// }

// // @lc code=end
