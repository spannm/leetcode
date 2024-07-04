package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Problem0929 extends LeetcodeProblem {

    int numUniqueEmails(String[] _emails) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String email : _emails) {
            String[] parts = email.split("@");
            if (!map.containsKey(parts[1])) {
                map.put(parts[1], new HashSet<>());
            }
            String filteredLocalName = parts[0].substring(0, parts[0].indexOf('+'));
            filteredLocalName = filteredLocalName.replace(".", "");
            map.get(parts[1]).add(filteredLocalName);
        }
        return map.keySet().stream().mapToInt(key -> map.get(key).size()).sum();
    }

}
