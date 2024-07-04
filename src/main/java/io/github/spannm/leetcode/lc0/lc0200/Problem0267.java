package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem0267 extends LeetcodeProblem {

    List<String> generatePalindromes(String _s) {
        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < _s.length(); i++) {
            char c = _s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }

        if (odd > 1) {
            return res;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();

            if (val % 2 != 0) {
                mid += key;
            }

            for (int i = 0; i < val / 2; i++) {
                list.add(key);
            }
        }

        genPerm(list, mid, new boolean[list.size()], new StringBuilder(), res);

        return res;
    }

    static void genPerm(List<Character> _list, String _mid, boolean[] _used, StringBuilder _sb, List<String> _res) {
        if (_sb.length() == _list.size()) {
            _res.add(_sb + _mid + _sb.reverse());
            _sb.reverse();
            return;
        }

        for (int i = 0; i < _list.size(); i++) {

            if (i > 0 && _list.get(i) == _list.get(i - 1) && !_used[i - 1]) {
                continue;
            }

            if (!_used[i]) {
                _used[i] = true;
                _sb.append(_list.get(i));

                genPerm(_list, _mid, _used, _sb, _res);

                _used[i] = false;
                _sb.deleteCharAt(_sb.length() - 1);
            }
        }
    }

}
