package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem0811 extends LeetcodeProblem {

    List<String> subdomainVisits(String[] _cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String each : _cpdomains) {
            String[] pair = each.split(" ");
            String[] subDomains = pair[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = subDomains.length - 1; i >= 0; i--) {
                if (i < subDomains.length - 1) {
                    sb.insert(0, ".");
                }
                sb.insert(0, subDomains[i]);
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + Integer.parseInt(pair[0]));
            }
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key) + " " + key);
        }
        return result;
    }

}
