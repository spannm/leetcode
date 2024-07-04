package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1409. Queries on a Permutation With Key
 * <p>
 * Given the array queries of positive integers between 1 and m, you have to process all queries[i] (from i=0 to
 * i=queries.length-1) according to the following rules: In the beginning, you have the permutation P=[1,2,3,...,m]. For
 * the current i, find the position of queries[i] in the permutation P (indexing from 0) and then move this at the
 * beginning of the permutation P. Notice that the position of queries[i] in P is the result for queries[i]. Return an
 * array containing the result for the given queries.
 * <p>
 * Example 1: Input: queries = [3,1,2,1], m = 5 Output: [2,1,2,1] Explanation: The queries are processed as follow: For
 * i=0: queries[i]=3, P=[1,2,3,4,5], position of 3 in P is 2, then we move 3 to the beginning of P resulting in
 * P=[3,1,2,4,5]. For i=1: queries[i]=1, P=[3,1,2,4,5], position of 1 in P is 1, then we move 1 to the beginning of P
 * resulting in P=[1,3,2,4,5]. For i=2: queries[i]=2, P=[1,3,2,4,5], position of 2 in P is 2, then we move 2 to the
 * beginning of P resulting in P=[2,1,3,4,5]. For i=3: queries[i]=1, P=[2,1,3,4,5], position of 1 in P is 1, then we
 * move 1 to the beginning of P resulting in P=[1,2,3,4,5]. Therefore, the array containing the result is [2,1,2,1].
 * <p>
 * Example 2: Input: queries = [4,1,2,2], m = 4 Output: [3,1,2,0]
 * <p>
 * Example 3: Input: queries = [7,5,5,8,3], m = 8 Output: [6,5,0,7,5]
 * <p>
 * Constraints: 1 <= m <= 10^3 1 <= queries.length <= m 1 <= queries[i] <= m
 */
class Problem1409 extends LeetcodeProblem {

    int[] processQueries(int[] _queries, int _m) {
        Map<Integer, Integer> indexToValMap = new HashMap<>();
        for (int i = 1; i <= _m; i++) {
            indexToValMap.put(i - 1, i);
        }
        int[] result = new int[_queries.length];
        for (int i = 0; i < _queries.length; i++) {
            int val = _queries[i];
            int pos = findPos(indexToValMap, val);
            result[i] = pos;
            for (int j = pos; j > 0; j--) {
                indexToValMap.put(j, indexToValMap.get(j - 1));
            }
            indexToValMap.put(0, val);
        }
        return result;
    }

    private static int findPos(Map<Integer, Integer> _map, int _val) {
        for (int pos : _map.keySet()) {
            if (_map.get(pos) == _val) {
                return pos;
            }
        }
        return -1;
    }

}
