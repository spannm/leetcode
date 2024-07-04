package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Problem1700 extends LeetcodeProblem {

    int countStudents(int[] _students, int[] _sandwiches) {
        Queue<Integer> students = Arrays.stream(_students).boxed().collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> sandwiches = Arrays.stream(_sandwiches).boxed().collect(Collectors.toCollection(LinkedList::new));
        while (!students.isEmpty()) {
            if (students.peek().equals(sandwiches.peek())) {
                students.poll();
                sandwiches.poll();
            } else {
                if (!students.contains(sandwiches.peek())) {
                    break;
                }
                students.add(students.poll());
            }
        }
        return students.size();
    }

}
