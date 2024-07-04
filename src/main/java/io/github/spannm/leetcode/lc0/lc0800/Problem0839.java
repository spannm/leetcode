package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/similar-string-groups/">839. Similar String Groups</a>.
 */
class Problem0839 extends LeetcodeProblem {

    int numSimilarGroups(String[] _strs) {
        final int len = _strs.length;
        final List<List<Integer>> neighbors = createGraph(_strs, len); // create an adjacency list to represent the
                                                                       // graph
        final boolean[] visited = new boolean[len]; // create a boolean array to keep track of visited nodes
        int count = 0;

        for (int idx = 0; idx < len; idx++) {
            if (!visited[idx]) { // traverse graph using DFS and count the number of connected components
                dfs(idx, visited, neighbors);
                count++;
            }
        }
        return count;
    }

    static List<List<Integer>> createGraph(String[] _strs, int _len) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < _len; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < _len; i++) {
            for (int j = i + 1; j < _len; j++) {
                if (isSimilar(_strs[i], _strs[j])) {
                    ans.get(i).add(j);
                    ans.get(j).add(i);
                }
            }
        }
        return ans;
    }

    static void dfs(int _idx, boolean[] _visited, List<List<Integer>> _neighbors) { // depth-first search to traverse
                                                                                    // the graph
        _visited[_idx] = true;
        for (int n : _neighbors.get(_idx)) {
            if (!_visited[n]) {
                dfs(n, _visited, _neighbors);
            }
        }
    }

    static boolean isSimilar(String _s1, String _s2) {
        int c = 0; // check if two strings are similar with max of 1 swap
        for (int i = 0; i < _s1.length(); i++) {
            if (_s1.charAt(i) != _s2.charAt(i)) {
                c++;
            }
        }
        return c == 0 || c == 2;
    }

}
