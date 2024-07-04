package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Problem1079 extends LeetcodeProblem {

    int numTilePossibilities(String _tiles) {
        char[] chars = _tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        dfs(chars, used, sb, result);
        return result.size();
    }

    private static void dfs(char[] _chars, boolean[] _used, StringBuilder _sb, List<String> _result) {
        if (!_sb.isEmpty()) {
            _result.add(_sb.toString());
        }
        IntStream.range(0, _chars.length)
            .filter(i -> !_used[i])
            .filter(i -> i == 0 || _chars[i - 1] != _chars[i] || _used[i - 1])
            .forEach(i -> {
                _used[i] = true;
                _sb.append(_chars[i]);
                dfs(_chars, _used, _sb, _result);
                _used[i] = false;
                _sb.deleteCharAt(_sb.length() - 1);
            });
    }

}
