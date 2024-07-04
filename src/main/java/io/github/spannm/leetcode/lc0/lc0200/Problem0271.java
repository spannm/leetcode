package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0271 extends LeetcodeProblem {

    String encode(List<String> _strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : _strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    List<String> decode(String _s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < _s.length()) {
            int slash = _s.indexOf('/', i);
            int size = Integer.parseInt(_s.substring(i, slash));
            result.add(_s.substring(slash + 1, slash + 1 + size));
            i = slash + size + 1;
        }
        return result;
    }

}
