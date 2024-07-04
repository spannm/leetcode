package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem2165 extends LeetcodeProblem {

    long smallestNumber(long _num) {
        if (_num == 0) {
            return _num;
        }
        boolean negative = _num < 0;
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        while (_num != 0) {
            int digit = (int) Math.abs(_num % 10);
            tmap.put(digit, tmap.getOrDefault(digit, 0) + 1);
            _num /= 10;
        }
        if (!negative) {
            if (tmap.firstKey() == 0) {
                int zeroCount = tmap.get(0);
                tmap.remove(0);
                StringBuilder sb = new StringBuilder();
                int time = 0;
                for (int key : tmap.keySet()) {
                    int count = tmap.get(key);
                    time++;
                    if (time == 1) {
                        sb.append(key);
                        while (zeroCount > 0) {
                            sb.append(0);
                            zeroCount--;
                        }
                        count--;
                    }
                    while (count > 0) {
                        sb.append(key);
                        count--;
                    }
                }
                return Long.parseLong(sb.toString());
            } else {
                StringBuilder sb = new StringBuilder();
                for (int key : tmap.keySet()) {
                    int count = tmap.get(key);
                    while (count > 0) {
                        sb.append(key);
                        count--;
                    }
                }
                return Long.parseLong(sb.toString());
            }
        } else {
            Set<Integer> keys = tmap.keySet();
            List<Integer> sorted = new ArrayList<>(keys);
            sorted.sort(Comparator.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for (Integer element : sorted) {
                int count = tmap.get(element);
                while (count > 0) {
                    sb.append(element);
                    count--;
                }
            }
            return -Long.parseLong(sb.toString());
        }
    }

}
