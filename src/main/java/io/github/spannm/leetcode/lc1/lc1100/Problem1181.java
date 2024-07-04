package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 1181. Before and After Puzzle.
 */
class Problem1181 extends LeetcodeProblem {

    List<String> beforeAndAfterPuzzles(String[] _phrases) {
        int n = _phrases.length;
        var ps = new String[n][];
        for (int i = 0; i < n; i++) {
            var ws = _phrases[i].split(" ");
            ps[i] = new String[] {ws[0], ws[ws.length - 1]};
        }
        Set<String> s = new HashSet<>();
        for (int i1 = 0; i1 < n; i1++) {
            for (int i2 = 0; i2 < n; i2++) {
                if (i1 != i2 && ps[i1][1].equals(ps[i2][0])) {
                    s.add(_phrases[i1] + _phrases[i2].substring(ps[i2][0].length()));
                }
            }
        }
        var ans = new ArrayList<>(s);
        Collections.sort(ans);
        return ans;
    }

}
