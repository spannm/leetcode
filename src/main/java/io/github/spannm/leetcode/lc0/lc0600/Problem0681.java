package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0681 extends LeetcodeProblem {

    String nextClosestTime(String _time) {
        int cur = 60 * Integer.parseInt(_time.substring(0, 2));
        cur += Integer.parseInt(_time.substring(3));
        Set<Integer> allowed = new HashSet<>();
        for (char c : _time.toCharArray()) {
            if (c != ':') {
                allowed.add(c - '0');
            }
        }

        while (true) {
            cur = (cur + 1) % (24 * 60);
            int[] digits = new int[] {cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10};
            search: {
                for (int d : digits) {
                    if (!allowed.contains(d)) {
                        break search;
                    }
                }
                return String.format("%02d:%02d", cur / 60, cur % 60);
            }
        }
    }

}
