package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1268 extends LeetcodeProblem {

    List<List<String>> suggestedProducts(String[] _products, String _searchWord) {
        TrieNode root = buildTrie(_products);
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i <= _searchWord.length(); i++) {
            result.add(findTopThreeMatches(root, _searchWord.substring(0, i)));
        }
        return result;
    }

    private List<String> findTopThreeMatches(TrieNode _root, String _searchTerm) {
        List<String> result = new ArrayList<>();
        TrieNode node = _root;
        for (char c : _searchTerm.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return result;
            } else {
                node = node.children[c - 'a'];
            }
        }
        if (node.isWord) {
            result.add(_searchTerm);
        }
        for (TrieNode child : node.children) {
            if (child != null) {
                List<String> thisResult = dfs(child, _searchTerm, new ArrayList<>());
                result.addAll(thisResult);
                if (result.size() >= 3) {
                    return result.subList(0, 3);
                }
            }
        }
        return result;
    }

    private List<String> dfs(TrieNode _node, String _substring, List<String> _result) {
        if (_node.isWord) {
            _result.add(_substring + _node.c);
            if (_result.size() >= 3) {
                return _result;
            }
        }
        for (TrieNode child : _node.children) {
            if (child != null) {
                dfs(child, _substring + _node.c, _result);
            }
        }
        return _result;
    }

    private TrieNode buildTrie(String[] _products) {
        TrieNode root = new TrieNode(' ');
        for (String pro : _products) {
            insert(pro, root);
        }
        return root;
    }

    private void insert(String _word, TrieNode _root) {
        TrieNode node = _root;
        for (int i = 0; i < _word.length(); i++) {
            char c = _word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    static class TrieNode {
        private final TrieNode[] children;
        private boolean          isWord;
        private final char       c;

        TrieNode(char _c) {
            c = _c;
            children = new TrieNode[26];
        }
    }

}
