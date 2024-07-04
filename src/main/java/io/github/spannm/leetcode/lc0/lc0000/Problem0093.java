package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0093 extends LeetcodeProblem {

    List<String> restoreIpAddresses(String _s) {
        if (_s == null || _s.length() > 12 || _s.length() < 4) {
            return List.of();
        }
        return backtrack(_s, new ArrayList<>(), new ArrayList<>(), 0);
    }

    private static List<String> backtrack(String _s, List<String> _bytes, List<String> _results, int _pos) {
        if (_bytes.size() == 4) {
            if (_pos != _s.length()) {
                return _results;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(_bytes.get(i))
                    .append(".");
            }
            sb.setLength(sb.length() - 1);
            _results.add(sb.toString());
            return _results;
        }

        for (int i = _pos; i < _pos + 4 && i < _s.length(); i++) {
            String oneByte = _s.substring(_pos, i + 1);
            if (!isValid(oneByte)) {
                continue;
            }
            _bytes.add(oneByte);
            backtrack(_s, _bytes, _results, i + 1);
            _bytes.remove(_bytes.size() - 1);
        }
        return _results;
    }

    private static boolean isValid(String _oneByte) {
        if (_oneByte.charAt(0) == '0') {
            return "0".equals(_oneByte);
        }
        int num = Integer.parseInt(_oneByte);
        return num >= 0 && num < 256;
    }

}
