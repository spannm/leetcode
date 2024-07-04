package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0721 extends LeetcodeProblem {

    List<List<String>> accountsMerge(List<List<String>> _accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> account : _accounts) {
            String name = "";
            for (String email : account) {
                if (name.isEmpty()) {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x -> new ArrayList<>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x -> new ArrayList<>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for (String email : graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack<>();
                stack.push(email);
                List<String> component = new ArrayList<>();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei : graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }

}
