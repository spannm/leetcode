package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/successful-pairs-of-spells-and-potions/">2300. Successful Pairs of Spells and
 * Potions</a>.
 */
class Problem2300 extends LeetcodeProblem {

    int[] successfulPairs(final int[] _spells, final int[] _potions, final long _success) {
        final int spellCount = _spells.length;
        final int potionCount = _potions.length;
        final int[] results = new int[spellCount];

        Map<Integer, Integer> cache = new LinkedHashMap<>();

        Arrays.sort(_potions);

        for (int s = 0; s < spellCount; s++) {
            int spell = _spells[s];

            int successCount = cache.computeIfAbsent(spell,
                i -> {
                    int minIndex = binSearch(spell, _potions, _success);
                    return potionCount - minIndex;
                });

            results[s] = successCount;
        }

        for (int s = 0; s < spellCount; s++) {
            int spell = _spells[s];
            int successCount = cache.computeIfAbsent(spell,
                i -> (int) IntStream.of(_potions)
                    .mapToLong(p -> (long) p * spell)
                    .filter(x -> x >= _success).count());
            results[s] = successCount;
        }
        return results;
    }

    static int binSearch(int _spell, int[] _potions, long _success) {
        int left = 0;
        int right = _potions.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long product = (long) _spell * _potions[mid];
            if (product < _success) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}
