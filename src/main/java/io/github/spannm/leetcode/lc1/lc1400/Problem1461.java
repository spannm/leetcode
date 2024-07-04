package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem1461 extends LeetcodeProblem {

    boolean hasAllCodes(String _s, int _k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= _s.length() - _k; i++) {
            set.add(_s.substring(i, i + _k));
        }
        return set.size() == 1 << _k;
    }

}
