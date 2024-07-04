package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0411 extends LeetcodeProblem {

    private final Trie   root = new Trie();
    private List<String> abbrs;

    String minAbbreviation(String _target, String[] _dictionary) {
        for (String s : _dictionary) {
            addTrie(s);
        }

        for (int i = 0; i < _target.length(); i++) {
            abbrs = new ArrayList<>();
            abbrGenerator(_target, 0, "", 0, i + 1);
            for (String s : abbrs) {
                if (!search(s, root, 0, 0)) {
                    return s;
                }
            }
        }
        return "";
    }

    void addTrie(String _s) {
        Trie cur = root;
        for (int i = 0; i < _s.length(); i++) {
            char c = _s.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Trie();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    boolean search(String _target, Trie _root, int _i, int _loop) {
        if (_root == null) {
            return false;
        }

        if (_loop != 0) {
            for (int a = 0; a < 26; a++) {
                if (search(_target, _root.children[a], _i, _loop - 1)) {
                    return true;
                }
            }
            return false;
        } else if (_i == _target.length()) {
            return _root.isWord;
        }
        if (Character.isDigit(_target.charAt(_i))) {
            int tmp = 0;
            while (_i < _target.length() && Character.isDigit(_target.charAt(_i))) {
                tmp = tmp * 10 + _target.charAt(_i) - '0';
                _i++;
            }
            return search(_target, _root, _i, tmp);
        } else {
            return search(_target, _root.children[_target.charAt(_i) - 'a'], _i + 1, 0);
        }
    }

    void abbrGenerator(String _target, int _i, String _tmp, int _abbr, int _num) {
        if (_i == _target.length()) {
            if (_num == 0 && _abbr == 0) {
                abbrs.add(_tmp);
            }
            if (_num == 1 && _abbr != 0) {
                abbrs.add(_tmp + _abbr);
            }
            return;
        }
        if (_num <= 0) {
            return;
        }
        char cur = _target.charAt(_i);
        abbrGenerator(_target, _i + 1, _abbr == 0 ? _tmp + cur : _tmp + _abbr + cur, 0,
            _abbr == 0 ? _num - 1 : _num - 2);
        abbrGenerator(_target, _i + 1, _tmp, _abbr + 1, _num);
    }

    static class Trie {
        private final Trie[] children = new Trie[26];
        private boolean      isWord   = false;
    }

}
