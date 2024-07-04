package io.github.spannm.leetcode.lc1.lc1400;

import static java.util.function.Predicate.not;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem1436 extends LeetcodeProblem {

    String destCity(List<List<String>> _paths) {
        Set<String> sources = new HashSet<>();
        Set<String> dests = new HashSet<>();

        for (List<String> path : _paths) {
            String source = path.get(0);
            String dest = path.get(1);
            sources.add(source);
            dests.add(dest);
        }

        return dests.stream().filter(not(sources::contains)).findFirst().orElse("");
    }

}
