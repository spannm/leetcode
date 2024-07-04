package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2416. Sum of Prefix Scores of Strings.
 */
class Problem2416 extends LeetcodeProblem {

    int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ans[i] = trie.search(words[i]);
        }
        return ans;
    }

    static class Trie {
        private final Trie[] children = new Trie[26];
        private int          cnt;

        public void insert(String w) {
            Trie node = this;
            for (char c : w.toCharArray()) {
                c -= 'a';
                if (node.children[c] == null) {
                    node.children[c] = new Trie();
                }
                node = node.children[c];
                node.cnt++;
            }
        }

        public int search(String w) {
            Trie node = this;
            int ans = 0;
            for (char c : w.toCharArray()) {
                c -= 'a';
                if (node.children[c] == null) {
                    return ans;
                }
                node = node.children[c];
                ans += node.cnt;
            }
            return ans;
        }

    }

}
