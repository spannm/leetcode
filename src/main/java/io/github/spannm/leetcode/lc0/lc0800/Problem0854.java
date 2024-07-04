package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 854. K-Similar Strings.
 */
class Problem0854 extends LeetcodeProblem {

    int kSimilarity(String _s1, String _s2) {
        Deque<String> q = new ArrayDeque<>();
        Set<String> vis = new HashSet<>();
        q.offer(_s1);
        vis.add(_s1);
        int ans = 0;
        while (true) {
            for (int i = q.size(); i > 0; i--) {
                String s = q.pollFirst();
                if (s.equals(_s2)) {
                    return ans;
                }
                for (String nxt : next(s, _s2)) {
                    if (!vis.contains(nxt)) {
                        vis.add(nxt);
                        q.offer(nxt);
                    }
                }
            }
            ans++;
        }
    }

    static List<String> next(String _s, String _s2) {
        int i = 0;
        int len = _s.length();
        char[] cs = _s.toCharArray();
        while (cs[i] == _s2.charAt(i)) {
            i++;
        }

        List<String> res = new ArrayList<>();
        for (int j = i + 1; j < len; j++) {
            if (cs[j] == _s2.charAt(i) && cs[j] != _s2.charAt(j)) {
                swap(cs, i, j);
                res.add(new String(cs));
                swap(cs, i, j);
            }
        }
        return res;
    }

    static void swap(char[] _cs, int _i1, int _i2) {
        char t = _cs[_i1];
        _cs[_i1] = _cs[_i2];
        _cs[_i2] = t;
    }

}
