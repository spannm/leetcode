package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem0756 extends LeetcodeProblem {

    boolean pyramidTransition(String _bottom, List<String> _allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : _allowed) {
            String key = s.substring(0, 2);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s.substring(2));
        }

        return helper(_bottom, map);
    }

    private static boolean helper(String _bottom, Map<String, List<String>> _map) {
        if (_bottom.length() == 1) {
            return true;
        }
        for (int i = 0; i < _bottom.length() - 1; i++) {
            if (!_map.containsKey(_bottom.substring(i, i + 2))) {
                return false;
            }
        }
        List<String> ls = new ArrayList<>();
        createList(_bottom, 0, new StringBuilder(), ls, _map);
        for (String s : ls) {
            if (helper(s, _map)) {
                return true;
            }
        }
        return false;
    }

    private static void createList(String _bottom, int _idx, StringBuilder _sb, List<String> _ls, Map<String, List<String>> _map) {
        if (_idx == _bottom.length() - 1) {
            _ls.add(_sb.toString());
            return;
        }
        for (String s : _map.get(_bottom.substring(_idx, _idx + 2))) {
            _sb.append(s);
            createList(_bottom, _idx + 1, _sb, _ls, _map);
            _sb.deleteCharAt(_sb.length() - 1);
        }
    }

}
