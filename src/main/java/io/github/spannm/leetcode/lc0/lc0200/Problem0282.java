package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0282 extends LeetcodeProblem {

    List<String> addOperators(String _num, int _target) {
        return dfs(new ArrayList<>(), new StringBuilder(), _num, 0, _target, 0, 0);
    }

    static List<String> dfs(List<String> _res, StringBuilder _sb, String _num, int _pos, int _target, long _prev, long _multi) {
        if (_pos == _num.length()) {
            if (_target == _prev) {
                _res.add(_sb.toString());
            }
            return _res;
        }
        for (int i = _pos; i < _num.length(); i++) {
            if (_num.charAt(_pos) == '0' && i != _pos) {
                break;
            }
            long curr = Long.parseLong(_num.substring(_pos, i + 1));
            int len = _sb.length();
            if (_pos == 0) {
                dfs(_res, _sb.append(curr), _num, i + 1, _target, curr, curr);
            } else {
                dfs(_res, _sb.append("+").append(curr), _num, i + 1, _target, _prev + curr, curr);
                _sb.setLength(len);

                dfs(_res, _sb.append("-").append(curr), _num, i + 1, _target, _prev - curr, -curr);
                _sb.setLength(len);

                dfs(_res, _sb.append("*").append(curr), _num, i + 1, _target, _prev - _multi + _multi * curr, _multi * curr);
            }
            _sb.setLength(len);
        }
        return _res;
    }

}
