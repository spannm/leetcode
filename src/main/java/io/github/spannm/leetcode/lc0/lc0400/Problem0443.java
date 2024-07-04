package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/string-compression/">443. String Compression</a>.
 */
class Problem0443 extends LeetcodeProblem {

    int compress(char[] _chars) {
        final int len = _chars.length;
        if (len == 1) {
            return 1;
        }
        int idxBgnGroup = 0;
        int idxOutput = 0;
        int idx = 0;
        char prev = _chars[idx];

        for (; idx < len; idx++) {
            char curr = _chars[idx];
            int groupLen = 0;
            boolean last = idx == len - 1;
            if (last) {
                _chars[idxOutput++] = prev;
                groupLen = idx - idxBgnGroup;
                if (curr == prev) {
                    groupLen++;
                }
                if (groupLen > 1) {
                    for (char d : Integer.toString(groupLen).toCharArray()) {
                        _chars[idxOutput++] = d;
                    }
                }
                if (curr != prev) {
                    _chars[idxOutput++] = curr;
                }
            } else if (curr != prev) {
                _chars[idxOutput++] = prev;
                groupLen = idx - idxBgnGroup;
                if (groupLen > 1) {
                    for (char d : Integer.toString(groupLen).toCharArray()) {
                        _chars[idxOutput++] = d;
                    }
                }

                prev = curr;
                idxBgnGroup = idx;
            }

        }

        return idxOutput;
    }

}
