package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Problem1796 extends LeetcodeProblem {

    int secondHighest(String _s) {
        TreeSet<Integer> set = new TreeSet<>();
        for (char c : _s.toCharArray()) {
            if (Character.isDigit(c)) {
                set.add(Character.getNumericValue(c));
            }
        }
        if (set.isEmpty() || set.size() == 1) {
            return -1;
        }
        List<Integer> list = new ArrayList<>(set);
        return list.get(list.size() - 2);
    }

}
