package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem1257 extends LeetcodeProblem {

    String findSmallestRegion(List<List<String>> _regions, String _region1, String _region2) {
        Map<String, String> childToParent = new HashMap<>();
        for (List<String> region : _regions) {
            for (int i = 1; i < region.size(); i++) {
                String parent = region.get(0);
                String child = region.get(i);
                childToParent.put(child, parent);
            }
        }
        List<String> path1 = findPath(childToParent, _region1);
        List<String> path2 = findPath(childToParent, _region2);
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i >= 0 && j >= 0) {
            if (path1.get(i).equals(path2.get(j))) {
                i--;
                j--;
            } else {
                if (i == path1.size() - 1) {
                    return path1.get(i);
                } else {
                    return path1.get(i + 1);
                }
            }
        }
        if (i < 0) {
            return path1.get(0);
        } else {
            return path2.get(0);
        }
    }

    private List<String> findPath(Map<String, String> _childToParent, String _leaf) {
        List<String> path = new ArrayList<>();
        do {
            path.add(_leaf);
            if (_childToParent.containsKey(_leaf)) {
                _leaf = _childToParent.get(_leaf);
            } else {
                break;
            }
        } while (true);
        return path;
    }

}
