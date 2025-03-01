package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1616. Split Two Strings to Make Palindrome.
 */
class Problem1616 extends LeetcodeProblem {

    boolean checkPalindromeFormation(String a, String b) {
        return check1(a, b) || check1(b, a);
    }

    private boolean check1(String a, String b) {
        int i = 0;
        int j = b.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            i++;
            j--;
        }
        return i >= j || check2(a, i, j) || check2(b, i, j);
    }

    private boolean check2(String a, int i, int j) {
        while (i < j && a.charAt(i) == a.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }

}
