package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem1367 extends LeetcodeProblem {
    private final List<List<Integer>> paths = new ArrayList<>();

    boolean isSubPath(ListNode _head, TreeNode _root) {
        List<Integer> list = getList(_head);
        findAllPaths(_root, new ArrayList<>());
        for (List<Integer> path : paths) {
            if (path.size() >= list.size()) {
                if (find(list, path)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(List<Integer> _list, List<Integer> _path) {
        int i = 0;
        int j = 0;
        for (; i <= _path.size() - _list.size(); i++) {
            j = 0;
            int tmpI = i;
            while (j < _list.size() && tmpI < _path.size() && _list.get(j).equals(_path.get(tmpI))) {
                tmpI++;
                j++;
            }
            if (j >= _list.size()) {
                return true;
            }
        }
        return j >= _list.size();
    }

    private void findAllPaths(TreeNode _root, List<Integer> _path) {
        if (_root == null) {
            return;
        }
        _path.add(_root.val);
        if (_root.left == null && _root.right == null) {
            paths.add(new ArrayList<>(_path));
            _path.remove(_path.size() - 1);
            return;
        }
        findAllPaths(_root.left, _path);
        findAllPaths(_root.right, _path);
        _path.remove(_path.size() - 1);
    }

    private List<Integer> getList(ListNode _head) {
        List<Integer> list = new ArrayList<>();
        while (_head != null) {
            list.add(_head.val);
            _head = _head.next;
        }
        return list;
    }

}
