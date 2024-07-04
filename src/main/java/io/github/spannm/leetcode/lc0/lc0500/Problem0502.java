package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/ipo/">502. IPO</a>.
 */
class Problem0502 extends LeetcodeProblem {

    int findMaximizedCapital(int _k, int _w, int[] _profits, int[] _capital) {
        return findMaximizedCapitalImpl(_k, _w, _profits, _capital);
    }

    int findMaximizedCapitalImpl(int _maxProjects, int _initialCapital, int[] _arrProfits, int[] _arrCapital) {

        List<Project> cpList = java.util.stream.IntStream.range(0, _arrCapital.length)
            .mapToObj(i -> new Project(_arrCapital[i], _arrProfits[i]))
            .sorted(Comparator.comparing(Project::getProfit, Comparator.reverseOrder()))
            .collect(Collectors.toCollection(ArrayList::new));

        int availCapital = _initialCapital;

        for (int projCount = 1; projCount <= _maxProjects; projCount++) {
            final int finAvailableCapital = availCapital;
            java.util.Optional<Project> mostProfitableDoableProj = cpList.stream()
                .filter(cp -> finAvailableCapital >= cp.reqCapital).findFirst();
            if (mostProfitableDoableProj.isEmpty()) {
                break;
            }
            availCapital += mostProfitableDoableProj.get().profit;
            cpList.remove(mostProfitableDoableProj.get());
        }

        return availCapital;
    }

    static final class Project {
        private final int reqCapital;
        private final int profit;

        Project(int _reqCapital, int _profit) {
            reqCapital = _reqCapital;
            profit = _profit;
        }

        public int getProfit() {
            return profit;
        }

        @Override
        public int hashCode() {
            return Objects.hash(reqCapital, profit);
        }

        @Override
        public boolean equals(Object _obj) {
            if (this == _obj) {
                return true;
            } else if (_obj == null || getClass() != _obj.getClass()) {
                return false;
            }
            Project other = (Project) _obj;
            return reqCapital == other.reqCapital && profit == other.profit;
        }

        @Override
        public String toString() {
            return String.format("Proj[reqCap=%s, prof=%s]", reqCapital, profit);
        }

    }

}
