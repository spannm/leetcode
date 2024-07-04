package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1096. Brace Expansion II.
 */
class Problem1096 extends LeetcodeProblem {

    List<String> braceExpansionII(String _expr) {
        return new ArrayList<>(dfs(_expr, new TreeSet<>()));
    }

    static Set<String> dfs(String _exp, Set<String> _set) {
        int idxClose = _exp.indexOf('}');
        if (idxClose == -1) {
            _set.add(_exp);
        } else {
            int idxOpen = _exp.lastIndexOf('{', idxClose);
            String a = _exp.substring(0, idxOpen);
            String c = _exp.substring(idxClose + 1);
            for (String b : _exp.substring(idxOpen + 1, idxClose).split(",")) {
                dfs(a + b + c, _set);
            }
        }
        return _set;
    }

}
