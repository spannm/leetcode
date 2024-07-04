package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeMap;

class Problem0729 extends LeetcodeProblem {

    static class MyCalendar {
        private final TreeMap<Integer, Integer> calendar;

        MyCalendar() {
            calendar = new TreeMap<>();
        }

        boolean book(int _start, int _end) {
            Integer floorKey = calendar.floorKey(_start);
            if (floorKey != null && calendar.get(floorKey) > _start) {
                return false;
            }
            Integer ceilingKey = calendar.ceilingKey(_start);
            if (ceilingKey != null && ceilingKey < _end) {
                return false;
            }
            calendar.put(_start, _end);
            return true;
        }
    }

}
