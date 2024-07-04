package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2384. Largest Palindromic Number.
 */
class Problem2384 extends LeetcodeProblem {

    String largestPalindromic(String num) {
        int[] cnt = new int[10];
        for (char c : num.toCharArray()) {
            ++cnt[c - '0'];
        }
        String mid = "";
        for (int i = 9; i >= 0; i--) {
            if (cnt[i] % 2 == 1) {
                mid += i;
                cnt[i]--;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (cnt[i] > 0) {
                cnt[i] >>= 1;
                sb.append(("" + i).repeat(cnt[i]));
            }
        }
        while (!sb.isEmpty() && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String t = sb.toString();
        String ans = sb.reverse() + mid + t;
        return ans.isEmpty() ? "0" : ans;
    }

}
