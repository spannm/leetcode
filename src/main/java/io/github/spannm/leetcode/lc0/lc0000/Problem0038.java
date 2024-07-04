package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/count-and-say/">38. Count and Say</a>.
 */
class Problem0038 extends LeetcodeProblem {

    String countAndSay(final int _n) {
        final StringBuilder curr = new StringBuilder("1");
        final StringBuilder prev = new StringBuilder();
        int count;
        char say;
        for (int i = 1; i < _n; i++) {
            prev.setLength(0);
            prev.append(curr);
            curr.setLength(0);
            count = 1;
            say = prev.charAt(0);

            for (int j = 1, len = prev.length(); j < len; j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else {
                    count++;
                }
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }

}
