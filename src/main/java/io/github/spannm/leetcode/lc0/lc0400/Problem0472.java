package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 472. Concatenated Words.
 */
class Problem0472 extends LeetcodeProblem {

    List<String> findAllConcatenatedWordsInADict(String[] _words) {
        Arrays.sort(_words, Comparator.comparingInt(String::length));
        Trie trie = new Trie();
        List<String> ans = new ArrayList<>();
        for (String w : _words) {
            if (dfs(w, trie)) {
                ans.add(w);
            } else {
                trie.insert(w);
            }
        }
        return ans;
    }

    static boolean dfs(String _w, Trie _trie) {
        if ("".equals(_w)) {
            return true;
        }
        Trie node = _trie;
        for (int i = 0; i < _w.length(); i++) {
            int idx = _w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
            if (node.isEnd && dfs(_w.substring(i + 1), _trie)) {
                return true;
            }
        }
        return false;
    }

    static class Trie {
        private final Trie[]  children = new Trie[26];
        private boolean isEnd;

        void insert(String w) {
            Trie node = this;
            for (char c : w.toCharArray()) {
                c -= 'a';
                if (node.children[c] == null) {
                    node.children[c] = new Trie();
                }
                node = node.children[c];
            }
            node.isEnd = true;
        }

    }

}
