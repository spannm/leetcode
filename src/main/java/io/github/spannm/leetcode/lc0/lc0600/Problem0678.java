package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 678. Valid Parenthesis String.
 */
public class Problem0678 extends LeetcodeProblem {

    boolean checkValidString(String s) {
        int len = s.length();
        boolean[][] mem = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            mem[i][i] = '*' == s.charAt(i);
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                mem[i][j] = ('(' == ci || '*' == ci) && ('*' == cj || ')' == cj) && (i + 1 == j || mem[i + 1][j - 1]);
                for (int k = i; k < j && !mem[i][j]; k++) {
                    mem[i][j] = mem[i][k] && mem[k + 1][j];
                }
            }
        }
        return mem[0][len - 1];
    }

}
