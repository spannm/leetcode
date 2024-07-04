package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1668 extends LeetcodeProblem {

    int maxRepeating(String _sequence, String _word) {
        StringBuilder sb = new StringBuilder(_word);
        int times = 0;
        while (_sequence.contains(sb.toString())) {
            times++;
            sb.append(_word);
        }
        return times;
    }

}
