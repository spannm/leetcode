package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0401 extends LeetcodeProblem {

    List<String> readBinaryWatch(int _num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h * 64 + m) == _num) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }

}
