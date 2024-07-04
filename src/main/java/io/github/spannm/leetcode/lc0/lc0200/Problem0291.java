package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Problem0291 extends LeetcodeProblem {

    boolean wordPatternMatch(String _pattern, String _str) {
        return isMatch(_str, 0, _pattern, 0, new HashMap<>(), new HashSet<>());
    }

    static boolean isMatch(String _str, int _i, String _pattern, int _j, Map<Character, String> _map, Set<String> _set) {
        if (_i == _str.length() && _j == _pattern.length()) {
            return true;
        } else if (_i == _str.length() || _j == _pattern.length()) {
            return false;
        }

        char c = _pattern.charAt(_j);

        if (_map.containsKey(c)) {
            String s = _map.get(c);
            return _str.startsWith(s, _i) && isMatch(_str, _i + s.length(), _pattern, _j + 1, _map, _set);
        }

        for (int k = _i; k < _str.length(); k++) {
            String p = _str.substring(_i, k + 1);

            if (_set.contains(p)) {
                continue;
            }

            _map.put(c, p);
            _set.add(p);

            if (isMatch(_str, k + 1, _pattern, _j + 1, _map, _set)) {
                return true;
            }

            _map.remove(c);
            _set.remove(p);
        }

        return false;
    }

}
