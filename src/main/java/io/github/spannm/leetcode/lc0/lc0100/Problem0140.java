package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem0140 extends LeetcodeProblem {

    List<String> wordBreak(String _s, List<String> _wordDict) {
        return dfs(_s, _wordDict, new HashMap<>());
    }

    static List<String> dfs(String _s, List<String> _wordDict, Map<String, List<String>> _map) {
        if (_map.containsKey(_s)) {
            return _map.get(_s);
        }

        List<String> result = new ArrayList<>();
        if (_s.isEmpty()) {
            result.add("");
            return result;
        }

        for (String word : _wordDict) {
            if (_s.startsWith(word)) {
                List<String> subList = dfs(_s.substring(word.length()), _wordDict, _map);
                for (String sub : subList) {
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        _map.put(_s, result);
        return result;
    }

}
