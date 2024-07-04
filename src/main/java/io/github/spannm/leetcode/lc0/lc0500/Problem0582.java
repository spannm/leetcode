package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0582 extends LeetcodeProblem {

    List<Integer> killProcess(List<Integer> _pid, List<Integer> _ppid, int _kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < _pid.size(); i++) {
            map.computeIfAbsent(_ppid.get(i), k -> new LinkedList<>());
            map.get(_ppid.get(i)).add(_pid.get(i));
        }
        List<Integer> result = new LinkedList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offer(_kill);
        while (!stack.isEmpty()) {
            int curr = stack.poll();
            result.add(curr);
            List<Integer> list = map.get(curr);
            if (list != null) {
                stack.addAll(list);
            }
        }
        return result;
    }

}
