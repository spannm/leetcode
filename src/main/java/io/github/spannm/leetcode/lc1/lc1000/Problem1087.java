package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1087 extends LeetcodeProblem {

    String[] expand(String _s) {
        List<char[]> letters = parse(_s);
        List<String> result = backtracking(letters, 0, new StringBuilder(), new ArrayList<>());
        String[] r = result.toArray(String[]::new);
        Arrays.sort(r);
        return r;
    }

    private List<String> backtracking(List<char[]> _letters, int _start, StringBuilder _sb, List<String> _result) {
        if (_start >= _letters.size()) {
            _result.add(_sb.toString());
            return _result;
        }
        char[] chars = _letters.get(_start);
        for (char element : chars) {
            _sb.append(element);
            backtracking(_letters, _start + 1, _sb, _result);
            _sb.setLength(_sb.length() - 1);
        }
        return _result;
    }

    private List<char[]> parse(String _s) {
        List<char[]> result = new ArrayList<>();
        for (int i = 0; i < _s.length(); i++) {
            if (_s.charAt(i) == '{') {
                int start = i++;
                while (i < _s.length() && _s.charAt(i) != '}') {
                    i++;
                }
                String[] strings = _s.substring(start, i).split(",");
                char[] chars = new char[strings.length];
                for (int j = 0; j < strings.length; j++) {
                    chars[j] = strings[j].charAt(0);
                }
                result.add(chars);
            } else {
                char[] chars = new char[1];
                chars[0] = _s.charAt(i);
                result.add(chars);
            }
        }
        return result;
    }

}
