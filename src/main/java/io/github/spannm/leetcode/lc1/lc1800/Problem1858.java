package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1858. Longest Word With All Prefixes.
 */
class Problem1858 extends LeetcodeProblem {

    String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        String ans = "";
        for (String w : words) {
            if ((w.length() > ans.length() || w.length() == ans.length() && w.compareTo(ans) < 0)
                && trie.search(w)) {
                ans = w;
            }
        }
        return ans;
    }

    static class Trie {
        private final Trie[] children = new Trie[26];
        private boolean      isEnd;

        public void insert(String w) {
            Trie node = this;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        public boolean search(String w) {
            Trie node = this;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                node = node.children[idx];
                if (!node.isEnd) {
                    return false;
                }
            }
            return true;
        }

    }

}
