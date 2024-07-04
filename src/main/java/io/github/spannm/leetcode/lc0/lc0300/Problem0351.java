package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0351 extends LeetcodeProblem {

    private int[][]   jumps;
    private boolean[] visited;

    int numberOfPatterns(int _m, int _n) {
        jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = jumps[1][9] = jumps[9][1] = 5;
        jumps[9][3] = jumps[3][9] = 6;
        jumps[3][7] = jumps[7][3] = 5;
        visited = new boolean[10];
        int count = 0;
        count += dfs(1, 1, 0, _m, _n)
            * 4;
        count += dfs(2, 1, 0, _m, _n)
            * 4;
        count += dfs(5, 1, 0, _m, _n);
        return count;
    }

    private int dfs(int _num, int _len, int _count, int _m, int _n) {
        if (_len >= _m) {
            _count++;
        }
        _len++;
        if (_len > _n) {
            return _count;
        }
        visited[_num] = true;
        for (int next = 1; next <= 9; next++) {
            int jump = jumps[_num][next];
            if (!visited[next] && (jump == 0 || visited[jump])) {
                _count = dfs(next, _len, _count, _m, _n);
            }
        }
        visited[_num] = false;
        return _count;
    }

}
