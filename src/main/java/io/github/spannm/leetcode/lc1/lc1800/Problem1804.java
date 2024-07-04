package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1804 extends LeetcodeProblem {

    static class Trie {
        private final TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String _word) {
            TrieNode node = root;
            for (char c : _word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                if (node.children[c - 'a'].count < 0) {
                    node.children[c - 'a'].count = 0;
                }
                node.children[c - 'a'].count++;
                node = node.children[c - 'a'];
            }
            node.isWord = true;
            if (node.wordsCount < 0) {
                node.wordsCount = 0;
            }
            node.wordsCount++;
        }

        int countWordsEqualTo(String _word) {
            TrieNode node = root;
            for (char c : _word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return 0;
                }
                node = node.children[c - 'a'];
            }
            return node.isWord ? node.wordsCount : 0;
        }

        int countWordsStartingWith(String _prefix) {
            TrieNode node = root;
            for (char c : _prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return 0;
                }
                node = node.children[c - 'a'];
            }
            return Math.max(node.count, 0);
        }

        void erase(String _word) {
            TrieNode node = root;
            for (char c : _word.toCharArray()) {
                node.children[c - 'a'].count--;
                node = node.children[c - 'a'];
            }
            node.wordsCount--;
        }

        @SuppressWarnings("checkstyle:VisibilityModifierCheck")
        static class TrieNode {
            int              count;
            int              wordsCount;
            final TrieNode[] children;
            boolean          isWord;

            TrieNode() {
                children = new TrieNode[26];
            }
        }

    }

}
