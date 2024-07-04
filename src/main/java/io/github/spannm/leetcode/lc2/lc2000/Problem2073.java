package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Problem2073 extends LeetcodeProblem {

    int timeRequiredToBuy(int[] _tickets, int _k) {
        int time = 0;
        Deque<int[]> q = IntStream.range(0, _tickets.length).mapToObj(i -> new int[] {_tickets[i], i}).collect(Collectors.toCollection(LinkedList::new));
        while (!q.isEmpty()) {
            int[] curr = q.pollFirst();
            if (curr[0] - 1 > 0) {
                q.addLast(new int[] {curr[0] - 1, curr[1]});
            }
            time++;
            if (curr[1] == _k && curr[0] - 1 == 0) {
                return time;
            }
        }
        return time;
    }

}
