package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/reconstruct-itinerary/">332. Reconstruct Itinerary</a>.
 */
class Problem0332 extends LeetcodeProblem {

    List<String> findItinerary(final List<List<String>> _tickets) {
        Map<String, Queue<String>> flights = new HashMap<>();
        for (List<String> ticket : _tickets) {
            flights.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                .add(ticket.get(1));
        }
        return dfs("JFK", flights, new LinkedList<>());
    }

    static List<String> dfs(String _departure, Map<String, Queue<String>> _flights, LinkedList<String> _path) {
        Queue<String> arrivals = _flights.get(_departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), _flights, _path);
        }
        _path.addFirst(_departure);
        return _path;
    }

}
