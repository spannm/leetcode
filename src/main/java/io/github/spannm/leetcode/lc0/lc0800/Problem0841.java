package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0841 extends LeetcodeProblem {

    boolean canVisitAllRooms(List<List<Integer>> _rooms) {
        Set<Integer> unvisitedRooms = new HashSet<>();
        for (int i = 1; i < _rooms.size(); i++) {
            unvisitedRooms.add(i);
        }
        List<Integer> keys = _rooms.get(0);
        Queue<Integer> queue = new LinkedList<>();
        for (int key : keys) {
            queue.offer(key);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int roomIndex = queue.poll();
                unvisitedRooms.remove(roomIndex);
                for (Integer nextRoom : _rooms.get(roomIndex)) {
                    if (unvisitedRooms.contains(nextRoom) && !queue.contains(nextRoom)) {
                        queue.offer(nextRoom);
                    }
                }
            }
        }
        return unvisitedRooms.isEmpty();
    }

}
