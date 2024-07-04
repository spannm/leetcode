package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0269 extends LeetcodeProblem {

    String alienOrder(String[] _words) {
        if (_words == null || _words.length == 0) {
            return "";
        }

        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        String result = "";
        for (String s : _words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }
        for (int i = 0; i < _words.length - 1; i++) {
            String curr = _words[i];
            String next = _words[i + 1];
            if (curr.length() > next.length() && curr.startsWith(next)) {
                return "";
            }
            int minLen = Math.min(curr.length(), next.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = map.getOrDefault(c1, new HashSet<>());
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result += curr;
            if (map.containsKey(curr)) {
                for (char c : map.get(curr)) {
                    degree.put(c, degree.get(c) - 1);
                    if (degree.get(c) == 0) {
                        queue.offer(c);
                    }
                }
            }
        }
        if (result.length() != degree.size()) {
            result = "";
        }
        return result;
    }

}
