package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 539. Minimum Time Difference.
 */
class Problem0539 extends LeetcodeProblem {

    int findMinDifference(List<String> _timePoints) {
        if (_timePoints.size() > 24 * 60) {
            return 0;
        }
        List<Integer> mins = _timePoints.stream().map(tp -> tp.split(":"))
            .map(t -> Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1])).sorted().collect(Collectors.toList());
        mins.add(mins.get(0) + 24 * 60);
        int res = 24 * 60;
        for (int i = 1; i < mins.size(); i++) {
            res = Math.min(res, mins.get(i) - mins.get(i - 1));
        }
        return res;
    }

}
