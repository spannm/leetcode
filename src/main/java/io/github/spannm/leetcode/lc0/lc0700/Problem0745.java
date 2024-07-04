package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0745 extends LeetcodeProblem {

    static class Trie {
        private final Trie[]        children = new Trie[26];
        private final List<Integer> indexes  = new ArrayList<>();

        void insert(String _word, int _i) {
            Trie node = this;
            for (char c : _word.toCharArray()) {
                c -= 'a';
                if (node.children[c] == null) {
                    node.children[c] = new Trie();
                }
                node = node.children[c];
                node.indexes.add(_i);
            }
        }

        List<Integer> search(String _pref) {
            Trie node = this;
            for (char c : _pref.toCharArray()) {
                c -= 'a';
                if (node.children[c] == null) {
                    return List.of();
                }
                node = node.children[c];
            }
            return node.indexes;
        }

    }

    static class WordFilter {
        private final Trie p = new Trie();
        private final Trie s = new Trie();

        WordFilter(String[] _words) {
            for (int i = 0; i < _words.length; i++) {
                String w = _words[i];
                p.insert(w, i);
                s.insert(new StringBuilder(w).reverse().toString(), i);
            }
        }

        int f(String _pref, String _suff) {
            _suff = new StringBuilder(_suff).reverse().toString();
            List<Integer> a = p.search(_pref);
            List<Integer> b = s.search(_suff);
            if (a.isEmpty() || b.isEmpty()) {
                return -1;
            }
            int i = a.size() - 1;
            int j = b.size() - 1;
            while (i >= 0 && j >= 0) {
                int c = a.get(i);
                int d = b.get(j);
                if (c == d) {
                    return c;
                }
                if (c > d) {
                    i--;
                } else {
                    j--;
                }
            }
            return -1;
        }

    }
}
