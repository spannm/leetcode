package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1286 extends LeetcodeProblem {

    static class CombinationIterator {

        private final List<String> list;
        private int                index;
        private final int          combinationLength;

        CombinationIterator(String _characters, int _combinationLength) {
            index = 0;
            list = new ArrayList<>();
            combinationLength = _combinationLength;
            boolean[] visited = new boolean[_characters.length()];
            buildAllCombinations(_characters, 0, new StringBuilder(), visited);
        }

        private void buildAllCombinations(String _characters, int _start, StringBuilder _sb, boolean[] _visited) {
            if (_sb.length() == combinationLength) {
                list.add(_sb.toString());
            } else {
                for (int i = _start; i < _characters.length();) {
                    if (!_visited[i]) {
                        _sb.append(_characters.charAt(i));
                        _visited[i] = true;
                        buildAllCombinations(_characters, i++, _sb, _visited);
                        _visited[i - 1] = false;
                        _sb.setLength(_sb.length() - 1);
                    } else {
                        i++;
                    }
                }
            }
        }

        String next() {
            return list.get(index++);
        }

        boolean hasNext() {
            return index < list.size();
        }
    }

}
