package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0936 extends LeetcodeProblem {

    int[] movesToStamp(String _stamp, String _target) {
        List<Integer> moves = new ArrayList<>();
        char[] s = _stamp.toCharArray();
        char[] t = _target.toCharArray();
        int stars = 0;
        boolean[] visited = new boolean[_target.length()];
        while (stars < _target.length()) {
            boolean doneReplace = false;
            for (int i = 0; i <= _target.length() - _stamp.length(); i++) {
                if (!visited[i] && canReplace(t, i, s)) {
                    stars = doReplace(t, i, s, stars);
                    doneReplace = true;
                    visited[i] = true;
                    moves.add(i);
                    if (stars == t.length) {
                        break;
                    }
                }
            }
            if (!doneReplace) {
                return new int[0];
            }
        }

        int[] result = new int[moves.size()];
        for (int i = 0; i < moves.size(); i++) {
            result[i] = moves.get(moves.size() - i - 1);
        }
        return result;
    }

    private boolean canReplace(char[] _t, int _i, char[] _s) {
        for (int j = 0; j < _s.length; j++) {
            if (_t[_i + j] != '*' && _t[_i + j] != _s[j]) {
                return false;
            }
        }
        return true;
    }

    private int doReplace(char[] _t, int _i, char[] _s, int _stars) {
        for (int j = 0; j < _s.length; j++) {
            if (_t[_i + j] != '*') {
                _t[_i + j] = '*';
                _stars++;
            }
        }
        return _stars;
    }

}
