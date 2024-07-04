package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1233. Remove Sub-Folders from the Filesystem.
 */
class Problem1233 extends LeetcodeProblem {

    List<String> removeSubfolders(String[] _folder) {
        Arrays.sort(_folder);
        List<String> ans = new ArrayList<>();
        ans.add(_folder[0]);
        for (int i = 1; i < _folder.length; i++) {
            int m = ans.get(ans.size() - 1).length();
            int n = _folder[i].length();
            if (m >= n
                || !(ans.get(ans.size() - 1).equals(_folder[i].substring(0, m))
                    && _folder[i].charAt(m) == '/')) {
                ans.add(_folder[i]);
            }
        }
        return ans;
    }

}
