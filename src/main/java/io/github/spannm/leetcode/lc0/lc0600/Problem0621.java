package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0621 extends LeetcodeProblem {

    int leastInterval(char[] _tasks, int _n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : _tasks) {
            map.merge(c, 1, Integer::sum);
        }
        Queue<Task> maxHeap = new PriorityQueue<>((a, b) -> b.total - a.total);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(new Task(entry.getValue(), entry.getKey()));
        }
        int times = 0;
        while (!maxHeap.isEmpty()) {
            int i = 0;
            List<Task> temp = new ArrayList<>();
            while (i <= _n) {
                if (!maxHeap.isEmpty()) {
                    if (maxHeap.peek().total > 1) {
                        Task curr = maxHeap.poll();
                        temp.add(new Task(curr.total - 1, curr.character));
                    } else {
                        maxHeap.poll();
                    }
                }
                times++;
                if (maxHeap.isEmpty() && temp.isEmpty()) {
                    break;
                }
                i++;
            }
            for (Task task : temp) {
                maxHeap.offer(task);
            }
        }
        return times;
    }

    static class Task {
        private final int  total;
        private final char character;

        Task(int _total, char _c) {
            total = _total;
            character = _c;
        }
    }

}
