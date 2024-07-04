package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

class Problem0690 extends LeetcodeProblem {

    private int total = 0;

    int getImportance(List<Employee> _employees, int _id) {
        Employee manager = _employees.stream().filter(e -> e.id == _id).findFirst().orElseThrow();
        total += manager.importance;
        manager.subordinates.forEach(subId -> getImportance(_employees, subId));
        return total;
    }

    static class Employee {
        private final int           id;
        private final int           importance;
        private final List<Integer> subordinates;

        Employee(int _id, int _importance, List<Integer> _subordinates) {
            id = _id;
            importance = _importance;
            subordinates = _subordinates;
        }
    }

}
