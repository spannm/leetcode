package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 2071. Maximum Number of Tasks You Can Assign.
 */
class Problem2071 extends LeetcodeProblem {

    private int[] tasks;
    private int[] workers;
    private int   nbWorkers;
    private int   pills;
    private int   strength;

    int maxTaskAssign(int[] _tasks, int[] _workers, int _pills, int _strength) {
        Arrays.sort(_tasks);
        Arrays.sort(_workers);
        tasks = _tasks;
        workers = _workers;
        strength = _strength;
        pills = _pills;
        int nbTasks = _tasks.length;
        nbWorkers = _workers.length;
        int left = 0;
        int right = Math.min(nbWorkers, nbTasks);
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int _x) {
        int i = 0;
        Deque<Integer> q = new ArrayDeque<>();
        int p = pills;
        for (int j = nbWorkers - _x; j < nbWorkers; j++) {
            while (i < _x && tasks[i] <= workers[j] + strength) {
                q.offer(tasks[i++]);
            }
            if (q.isEmpty()) {
                return false;
            }
            if (q.peekFirst() <= workers[j]) {
                q.pollFirst();
            } else if (p == 0) {
                return false;
            } else {
                p--;
                q.pollLast();
            }
        }
        return true;
    }

}
