package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 2512. Reward Top K Students.
 */
class Problem2512 extends LeetcodeProblem {

    List<Integer> topStudents(String[] _positiveFeedback, String[] _negativeFeedback, String[] _report, int[] _studentId, int _k) {
        Set<String> pos = Arrays.stream(_positiveFeedback).collect(Collectors.toSet());
        Set<String> neg = Arrays.stream(_negativeFeedback).collect(Collectors.toSet());
        int nbReports = _report.length;
        int[][] arr = new int[nbReports][0];
        for (int r = 0; r < nbReports; r++) {
            int sid = _studentId[r];
            int t = 0;
            for (var s : _report[r].split(" ")) {
                if (pos.contains(s)) {
                    t += 3;
                } else if (neg.contains(s)) {
                    t -= 1;
                }
            }
            arr[r] = new int[] {t, sid};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        return IntStream.range(0, _k).mapToObj(i -> arr[i][1]).toList();
    }

}
