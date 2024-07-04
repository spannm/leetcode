package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1032 extends LeetcodeProblem {

    static class Trie {
        private final Trie[] children = new Trie[26];
        private boolean      isEnd    = false;

        public void insert(String _w) {
            Trie node = this;
            for (int i = _w.length() - 1; i >= 0; i--) {
                int idx = _w.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        public boolean query(StringBuilder _sb) {
            Trie node = this;
            for (int i = _sb.length() - 1; i >= 0; i--) {
                int idx = _sb.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
                if (node.isEnd) {
                    return true;
                }
            }
            return false;
        }

    }

    static class StreamChecker {
        private final StringBuilder sb   = new StringBuilder();
        private final Trie          trie = new Trie();

        StreamChecker(String[] _words) {
            for (String w : _words) {
                trie.insert(w);
            }
        }

        public boolean query(char _letter) {
            sb.append(_letter);
            return trie.query(sb);
        }

    }

}
