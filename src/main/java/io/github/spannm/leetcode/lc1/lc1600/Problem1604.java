package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 1604. Alert Using Same Key-Card Three or More Times in a One Hour Period.
 */
class Problem1604 extends LeetcodeProblem {

    List<String> alertNames(String[] _keyNames, String[] _keyTimes) {
        Map<String, List<Integer>> d = new HashMap<>();
        for (int i = 0; i < _keyNames.length; ++i) {
            String name = _keyNames[i];
            String time = _keyTimes[i];
            int t = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
            d.computeIfAbsent(name, k -> new ArrayList<>()).add(t);
        }
        List<String> result = new ArrayList<>();
        for (var e : d.entrySet()) {
            var ts = e.getValue();
            int n = ts.size();
            if (n > 2) {
                Collections.sort(ts);
                for (int i = 0; i < n - 2; ++i) {
                    if (ts.get(i + 2) - ts.get(i) <= 60) {
                        result.add(e.getKey());
                        break;
                    }
                }
            }
        }
        Collections.sort(result);
        return result;
    }

}
