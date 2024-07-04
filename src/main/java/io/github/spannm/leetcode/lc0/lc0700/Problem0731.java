package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;
import java.util.TreeMap;

class Problem0731 extends LeetcodeProblem {

    static class MyCalendarTwo {
        private final Map<Integer, Integer> tm = new TreeMap<>();

        public boolean book(int _start, int _end) {
            tm.put(_start, tm.getOrDefault(_start, 0) + 1);
            tm.put(_end, tm.getOrDefault(_end, 0) - 1);
            int s = 0;
            for (int v : tm.values()) {
                s += v;
                if (s > 2) {
                    tm.put(_start, tm.get(_start) - 1);
                    tm.put(_end, tm.get(_end) + 1);
                    return false;
                }
            }
            return true;
        }

    }

}
