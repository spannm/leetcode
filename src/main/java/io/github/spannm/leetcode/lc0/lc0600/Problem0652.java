package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-duplicate-subtrees/">652. Find Duplicate Subtrees</a>.
 */
class Problem0652 extends LeetcodeProblem {

    List<TreeNode> findDuplicateSubtrees(TreeNode _root) {
        List<TreeNode> dups = new ArrayList<>();
        countDups(_root, new HashMap<>(), dups);
        return dups;
    }

    static String countDups(TreeNode _root, Map<String, Integer> _count, List<TreeNode> _dups) {
        if (_root == null) {
            return "";
        }

        // '-' for encoding null left and right children
        final String key = _root.val + "-" + countDups(_root.left, _count, _dups) + "-" + countDups(_root.right, _count, _dups);
        _count.merge(key, 1, Integer::sum);
        // used to add the encoding to the count map. If the encoding already exists in the map, its count is
        // incremented by 1 using Integer::sum function. If it does not exist, a new entry is added with a count of 1
        // This ensures that each subtree encoding is counted exactly once in the map.
        if (_count.get(key) == 2) { // duplicate subtree found
            _dups.add(_root); // add to list of results
        }
        return key;
    }

    List<TreeNode> findDuplicateSubtrees2(TreeNode _root) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        collectSubTreesByValString(map, _root);
        return map.values().stream()
            .filter(l -> l.size() > 1)
            .map(l -> l.get(0))
            .toList();
    }

    /**
     * Collects tree nodes into a map of list of nodes by their toString representation.
     *
     * @param _map Map to collect into
     * @param _root the root of the tree
     */
    static void collectSubTreesByValString(final Map<String, List<TreeNode>> _map, TreeNode _root) {
        if (_root == null) {
            return;
        }
        String str = _root.toValString();
        List<TreeNode> list = _map.computeIfAbsent(str, k -> new ArrayList<>());
        list.add(_root);
        collectSubTreesByValString(_map, _root.left);
        collectSubTreesByValString(_map, _root.right);
    }

}
