package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0358 extends LeetcodeProblem {

    String rearrangeString(String _s, int _k) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : _s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> heap =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        heap.addAll(count.entrySet());

        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            Map.Entry<Character, Integer> entry = heap.poll();
            sb.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            waitQueue.offer(entry);
            if (waitQueue.size() < _k) {
                continue;
            }
            Map.Entry<Character, Integer> front = waitQueue.poll();
            if (front.getValue() > 0) {
                heap.offer(front);
            }
        }

        return sb.length() == _s.length() ? sb.toString() : "";
    }

}
