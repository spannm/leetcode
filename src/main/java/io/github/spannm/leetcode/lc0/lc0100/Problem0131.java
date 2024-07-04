package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindrome-partitioning/">131. Palindrome Partitioning</a>.
 */
class Problem0131 extends LeetcodeProblem {

    List<List<String>> partition(String _str) {
        return dfs(0, new ArrayList<>(), new ArrayList<>(), _str);
    }

    static List<List<String>> dfs(int _start, List<List<String>> _result, List<String> _currentList, String _str) {
        if (_start >= _str.length()) {
            _result.add(List.copyOf(_currentList));
        }
        for (int end = _start; end < _str.length(); end++) {
            if (isPalindrome(_str, _start, end)) {
                _currentList.add(_str.substring(_start, end + 1));
                dfs(end + 1, _result, _currentList, _str);
                _currentList.remove(_currentList.size() - 1);
            }
        }
        return _result;
    }

    static boolean isPalindrome(String _str, int _start, int _end) {
        while (_start < _end) {
            if (_str.charAt(_start++) != _str.charAt(_end--)) {
                return false;
            }
        }
        return true;
    }

}
