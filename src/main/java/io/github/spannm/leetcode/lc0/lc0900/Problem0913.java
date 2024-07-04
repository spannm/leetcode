package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 913. Cat and Mouse.
 */
class Problem0913 extends LeetcodeProblem {

    private static final int HOLE        = 0;
    private static final int MOUSE_START = 1;
    private static final int CAT_START   = 2;
    private static final int MOUSE_TURN  = 0;
    private static final int CAT_TURN    = 1;
    private static final int MOUSE_WIN   = 1;
    private static final int CAT_WIN     = 2;
    private static final int TIE         = 0;

    private int[][]          g;

    int catMouseGame(int[][] _graph) {
        int n = _graph.length;
        g = _graph;
        int[][][] res = new int[n][n][2];
        int[][][] degree = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                degree[i][j][MOUSE_TURN] = g[i].length;
                degree[i][j][CAT_TURN] = g[j].length;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j : g[HOLE]) {
                degree[i][j][CAT_TURN]--;
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        for (int j = 1; j < n; j++) {
            res[0][j][MOUSE_TURN] = MOUSE_WIN;
            res[0][j][CAT_TURN] = MOUSE_WIN;
            q.offer(new int[] {0, j, MOUSE_TURN});
            q.offer(new int[] {0, j, CAT_TURN});
        }
        for (int i = 1; i < n; i++) {
            res[i][i][MOUSE_TURN] = CAT_WIN;
            res[i][i][CAT_TURN] = CAT_WIN;
            q.offer(new int[] {i, i, MOUSE_TURN});
            q.offer(new int[] {i, i, CAT_TURN});
        }
        while (!q.isEmpty()) {
            int[] state = q.poll();
            int t = res[state[0]][state[1]][state[2]];
            List<int[]> prevStates = getPrevStates(state);
            for (var prevState : prevStates) {
                int pm = prevState[0];
                int pc = prevState[1];
                int pt = prevState[2];
                if (res[pm][pc][pt] == TIE) {
                    boolean win = t == MOUSE_WIN && pt == MOUSE_TURN || t == CAT_WIN && pt == CAT_TURN;
                    if (win) {
                        res[pm][pc][pt] = t;
                        q.offer(prevState);
                    } else {
                        if (--degree[pm][pc][pt] == 0) {
                            res[pm][pc][pt] = t;
                            q.offer(prevState);
                        }
                    }
                }
            }
        }
        return res[MOUSE_START][CAT_START][MOUSE_TURN];
    }

    List<int[]> getPrevStates(int[] _state) {
        List<int[]> pre = new ArrayList<>();
        int m = _state[0];
        int c = _state[1];
        int t = _state[2];
        int pt = t ^ 1;
        if (pt == CAT_TURN) {
            for (int pc : g[c]) {
                if (pc != HOLE) {
                    pre.add(new int[] {m, pc, pt});
                }
            }
        } else {
            for (int pm : g[m]) {
                pre.add(new int[] {pm, c, pt});
            }
        }
        return pre;
    }

}
