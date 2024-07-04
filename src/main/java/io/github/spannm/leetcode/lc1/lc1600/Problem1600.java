package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1600 extends LeetcodeProblem {

    static class ThroneInheritance {
        private final Map<String, List<String>> g    = new HashMap<>();
        private final Set<String>               dead = new HashSet<>();
        private List<String>                    ans;
        private final String                    king;

        ThroneInheritance(String _kingName) {
            king = _kingName;
        }

        void birth(String _parentName, String _childName) {
            g.computeIfAbsent(_parentName, k -> new ArrayList<>()).add(_childName);
        }

        void death(String _name) {
            dead.add(_name);
        }

        List<String> getInheritanceOrder() {
            ans = new ArrayList<>();
            dfs(king);
            return ans;
        }

        private void dfs(String _x) {
            if (!dead.contains(_x)) {
                ans.add(_x);
            }
            for (String y : g.getOrDefault(_x, List.of())) {
                dfs(y);
            }
        }

    }

}
