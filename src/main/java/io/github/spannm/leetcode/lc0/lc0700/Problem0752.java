package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 752. Open the Lock.
 */
public class Problem0752 extends LeetcodeProblem {

    int openLock(String[] _deadends, String _target) {
        String zeroes = "0000";
        if (zeroes.equals(_target)) {
            return 0;
        }
        Set<String> set = Arrays.stream(_deadends).collect(Collectors.toCollection(HashSet::new));
        if (set.contains(zeroes)) {
            return -1;
        }
        Queue<String> q = new ArrayDeque<>();
        q.offer(zeroes);
        set.add(zeroes);
        List<String> nextComb = new ArrayList<>(4 * 2);
        int result = 0;
        while (!q.isEmpty()) {
            result++;
            for (int n = q.size(); n > 0; n--) {
                String cw = q.poll();
                for (String nw : nextCombinations(cw, nextComb)) {
                    if (_target.equals(nw)) {
                        return result;
                    }
                    if (!set.contains(nw)) {
                        q.offer(nw);
                        set.add(nw);
                    }
                }
            }
        }
        return -1;
    }

    static List<String> nextCombinations(String _t, List<String> _list) {
        _list.clear();
        char[] chars = _t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            chars[i] = c == '0' ? '9' : (char) (c - 1);
            _list.add(String.valueOf(chars));
            chars[i] = c == '9' ? '0' : (char) (c + 1);
            _list.add(String.valueOf(chars));
            chars[i] = c;
        }
        return _list;
    }

}
