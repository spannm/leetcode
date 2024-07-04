package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0816 extends LeetcodeProblem {

    List<String> ambiguousCoordinates(String _s) {
        _s = _s.substring(1, _s.length() - 1);
        List<String> list = new ArrayList<>();
        for (int i = 1; i < _s.length(); i++) {
            String x = _s.substring(0, i);
            List<String> xs = findAllPossibilities(x);
            String y = _s.substring(i);
            List<String> ys = findAllPossibilities(y);
            for (String j : xs) {
                for (String k : ys) {
                    list.add("(" + j + ", " + k + ")");
                }
            }
        }
        return list;
    }

    private List<String> findAllPossibilities(String _s) {
        List<String> result = new ArrayList<>();
        if (_s.length() == 1) {
            result.add(_s);
            return result;
        } else {
            for (int i = 1; i < _s.length(); i++) {
                String integerPart = _s.substring(0, i);
                String floatPart = _s.substring(i);
                if (integerPart.length() > 1 && integerPart.charAt(0) != '0' && floatPart.charAt(floatPart.length() - 1) != '0') {
                    result.add(integerPart + "." + floatPart);
                } else if (integerPart.length() == 1 && floatPart.charAt(floatPart.length() - 1) != '0') {
                    result.add(integerPart + "." + floatPart);
                }
            }
            if (_s.charAt(0) != '0') {
                result.add(_s);
            }
        }
        return result;
    }

}
