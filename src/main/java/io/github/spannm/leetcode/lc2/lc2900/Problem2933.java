package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2933. High-Access Employees.
 */
class Problem2933 extends LeetcodeProblem {

    List<String> findHighAccessEmployees(List<List<String>> _accessTimes) {
        Map<String, List<Integer>> d = new HashMap<>();
        for (List<String> l : _accessTimes) {
            String name = l.get(0);
            String s = l.get(1);
            int t = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(2));
            d.computeIfAbsent(name, k -> new ArrayList<>()).add(t);
        }
        List<String> ans = new ArrayList<>();
        for (var e : d.entrySet()) {
            String name = e.getKey();
            var ts = e.getValue();
            Collections.sort(ts);
            for (int i = 2; i < ts.size(); i++) {
                if (ts.get(i) - ts.get(i - 2) < 60) {
                    ans.add(name);
                    break;
                }
            }
        }
        return ans;
    }

}
