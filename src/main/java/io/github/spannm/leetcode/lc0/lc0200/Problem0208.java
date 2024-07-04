package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/implement-trie-prefix-tree/">208. Implement Trie (Prefix Tree)</a>.
 */
class Problem0208 extends LeetcodeProblem {

    static final class Trie {
        private final TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String _word) {
            TrieNode node = root;
            for (char c : _word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isCompleteWord = true;
        }

        public boolean search(String _word) {
            TrieNode node = root;
            for (char c : _word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return node.isCompleteWord;
        }

        public boolean startsWith(String _prefix) {
            TrieNode node = root;
            for (char c : _prefix.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return true;
        }

        @Override
        public String toString() {
            return String.format("%s[root=%s]", getClass().getSimpleName(), root);
        }

        static final class TrieNode {
            private boolean          isCompleteWord;
            private final TrieNode[] children;

            TrieNode() {
                isCompleteWord = false; // when the word is complete (mark that node as true)
                children = new TrieNode[26]; // for 26 possible children (for next letter)
            }

            @Override
            public String toString() {
                return String.format("%s[isCompleteWord=%s, children=%s]",
                    getClass().getSimpleName(), isCompleteWord, children.length);
            }

        }

    }

}
