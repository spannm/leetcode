package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0293 extends LeetcodeProblem {

    List<String> generatePossibleNextMoves(String _s) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < _s.length(); i++) {
            if (_s.charAt(i) == '+' && _s.charAt(i - 1) == '+') {
                result.add(_s.substring(0, i - 1) + "--" + _s.substring(i + 1));
            }
        }
        return result;
    }

}
