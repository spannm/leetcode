package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem1100 extends LeetcodeProblem {

    int numKLenSubstrNoRepeats(String _s, int _k) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i <= _s.length() - _k; i++) {
            String string = _s.substring(i, i + _k);
            boolean invalid = false;
            for (char c : string.toCharArray()) {
                if (!set.add(c)) {
                    invalid = true;
                    break;
                }
            }
            count += invalid ? 0 : 1;
            set.clear();
        }
        return count;
    }

}
