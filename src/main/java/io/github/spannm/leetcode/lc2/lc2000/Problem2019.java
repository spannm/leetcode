package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2019. The Score of Students Solving Math Expression.
 */
class Problem2019 extends LeetcodeProblem {

    int scoreOfStudents(String _s, int[] _answers) {
        int n = _s.length();
        int x = cal(_s);
        int m = n + 1 >> 1;
        @SuppressWarnings("unchecked")
        Set<Integer>[][] f = new Set[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                f[i][j] = new HashSet<>();
            }
            f[i][i].add(_s.charAt(i << 1) - '0');
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i; j < m; j++) {
                for (int k = i; k < j; k++) {
                    for (int l : f[i][k]) {
                        for (int r : f[k + 1][j]) {
                            char op = _s.charAt(k << 1 | 1);
                            if (op == '+' && l + r <= 1000) {
                                f[i][j].add(l + r);
                            } else if (op == '*' && l * r <= 1000) {
                                f[i][j].add(l * r);
                            }
                        }
                    }
                }
            }
        }
        int[] cnt = new int[1001];
        for (int ans : _answers) {
            cnt[ans]++;
        }
        int ans = 5 * cnt[x];
        for (int i = 0; i <= 1000; i++) {
            if (i != x && f[0][m - 1].contains(i)) {
                ans += 2 * cnt[i];
            }
        }
        return ans;
    }

    private int cal(String s) {
        int res = 0;
        int pre = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i += 2) {
            char op = s.charAt(i);
            int cur = s.charAt(i + 1) - '0';
            if (op == '*') {
                pre *= cur;
            } else {
                res += pre;
                pre = cur;
            }
        }
        res += pre;
        return res;
    }

}
