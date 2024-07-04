package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem2076 extends LeetcodeProblem {

    boolean[] friendRequests(int _n, int[][] _restrictions, int[][] _requests) {
        int[] head = new int[_n];
        boolean[][] isr = new boolean[_n][_n];
        for (int i = 0; i < _n; i++) {
            head[i] = i;
        }
        List<List<Integer>> ch = new ArrayList<>();
        for (int i = 0; i < _n; i++) {
            ch.add(new ArrayList<>());
            ch.get(i).add(i);
        }
        for (int[] res : _restrictions) {
            isr[res[0]][res[1]] = true;
            isr[res[1]][res[0]] = true;
        }
        boolean[] ans = new boolean[_requests.length];
        for (int i = 0; i < _requests.length; i++) {
            int u = head[_requests[i][0]];
            int v = head[_requests[i][1]];
            if (u == v) {
                ans[i] = true;
                continue;
            }
            if (isr[u][v]) {
                continue;
            }
            ans[i] = true;
            for (int v2 : ch.get(v)) {
                ch.get(u).add(v2);
                head[v2] = u;
            }
            for (int j = 0; j < _n; j++) {
                isr[u][j] |= isr[v][j];
                isr[j][u] |= isr[j][v];
            }
        }
        return ans;
    }

}
