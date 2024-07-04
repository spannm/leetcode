package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2434. Using a Robot to Print the Lexicographically Smallest String.
 */
class Problem2434 extends LeetcodeProblem {

    String robotWithString(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        StringBuilder ans = new StringBuilder();
        Deque<Character> stk = new ArrayDeque<>();
        char mi = 'a';
        for (char c : s.toCharArray()) {
            --cnt[c - 'a'];
            while (mi < 'z' && cnt[mi - 'a'] == 0) {
                mi++;
            }
            stk.push(c);
            while (!stk.isEmpty() && stk.peek() <= mi) {
                ans.append(stk.pop());
            }
        }
        return ans.toString();
    }

}
