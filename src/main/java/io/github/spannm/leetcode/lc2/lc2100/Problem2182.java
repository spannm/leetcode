package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem2182 extends LeetcodeProblem {

    String repeatLimitedString(String _s, int _repeatLimit) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : _s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        Queue<Count> heap = new PriorityQueue<>((a, b) -> b.c - a.c);
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            heap.offer(new Count(e.getKey(), e.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            Count curr = heap.poll();
            int num = Math.min(curr.num, _repeatLimit);
            while (num > 0) {
                sb.append(curr.c);
                num--;
            }
            if (curr.num > _repeatLimit) {
                Count newCount = new Count(curr.c, curr.num - _repeatLimit);
                if (!heap.isEmpty()) {
                    Count next = heap.poll();
                    sb.append(next.c);
                    if (next.num > 1) {
                        heap.offer(new Count(next.c, next.num - 1));
                    }
                } else {
                    break;
                }
                heap.offer(newCount);
            }
        }
        return sb.toString();
    }

    static class Count {
        private final char c;
        private final int  num;

        Count(char _c, Integer _num) {
            c = _c;
            num = _num;
        }
    }

}
