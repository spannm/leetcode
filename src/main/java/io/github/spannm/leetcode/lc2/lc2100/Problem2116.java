package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2116 extends LeetcodeProblem {

    boolean canBeValid(String _s, String _locked) {
        return _s.length() % 2 == 0 && valid(_s, _locked, '(') && valid(_s, _locked, ')');
    }

    private boolean valid(String _s, String _locked, char _op) {
        int balance = 0;
        int wildcards = 0;
        int direction = _op == '(' ? 1 : -1;
        int start = _op == '(' ? 0 : _s.length() - 1;
        for (int i = start; i < _s.length() && i >= 0 && balance + wildcards >= 0; i += direction) {
            if (_locked.charAt(i) == '1') {
                balance += _s.charAt(i) == _op ? 1 : -1;
            } else {
                wildcards++;
            }
        }
        return wildcards + balance >= 0 && balance <= wildcards;
    }

}
