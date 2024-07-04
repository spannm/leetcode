package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/">2244. Minimum Rounds to Complete All
 * Tasks</a>.
 */
class Problem2244 extends LeetcodeProblem {

    int minimumRounds(int... _tasks) {
        Map<Integer, Integer> taskCounts = Arrays.stream(_tasks).boxed().collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.summingInt(s -> 1)));

        if (taskCounts.containsValue(1)) {
            return -1;
        }
        int rounds = 0;
        for (Map.Entry<Integer, Integer> e : taskCounts.entrySet()) {
            int count = e.getValue();
            int diffRounds = 0;

            if (count == 2 || count == 3) {
                diffRounds = 1;
            } else {
                // 4 and more tasks
                int mod3 = count % 3;
                diffRounds = switch (mod3) {
                    case 0 -> count / 3; // 3 tasks each round
                    case 1 -> count / 3 - 1 + 2; // 3 tasks all except 2 tasks twice
                    default -> count / 3 + 1; // 3 tasks all except 2 tasks once
                };
            }

            if (diffRounds == -1) {
                return -1;
            }
            rounds += diffRounds;
        }
        return rounds;
    }

}
