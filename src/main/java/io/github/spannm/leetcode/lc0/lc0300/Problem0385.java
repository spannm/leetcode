package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.NestedInteger;

import java.util.Stack;

class Problem0385 extends LeetcodeProblem {

    NestedInteger deserialize(String _s) {
        if (_s == null || _s.isEmpty()) {
            return new NestedInteger();
        }
        Stack<NestedInteger> workStack = new Stack<>();
        NestedInteger result = null;
        StringBuilder sb = new StringBuilder();
        int i = 0;

        if (_s.charAt(i) != '[') {
            sb.setLength(0);
            while (i < _s.length() && (Character.getNumericValue(_s.charAt(i)) < 10
                && Character.getNumericValue(_s.charAt(i)) >= 0 || _s.charAt(i) == '-')) {
                sb.append(_s.charAt(i));
                i++;
            }
            int num = Integer.parseInt(sb.toString());
            return new NestedInteger(num);
        } else {

            while (i < _s.length()) {
                if (_s.charAt(i) == '[') {
                    NestedInteger ni = new NestedInteger();

                    if (!workStack.isEmpty()) {
                        NestedInteger lastNi = workStack.pop();
                        lastNi.add(ni);
                        workStack.push(lastNi);
                    }
                    workStack.push(ni);
                    i++;
                } else if (_s.charAt(i) == ',') {
                    i++;
                } else if (_s.charAt(i) == ']') {
                    NestedInteger completedNi = workStack.pop();
                    result = completedNi;
                    i++;
                } else {

                    sb.setLength(0);
                    while (i < _s.length()
                        && (Character.getNumericValue(_s.charAt(i)) < 10 && Character
                            .getNumericValue(_s.charAt(i)) >= 0 || _s.charAt(i) == '-')) {
                        sb.append(_s.charAt(i));
                        i++;
                    }
                    int num = Integer.parseInt(sb.toString());
                    NestedInteger ni = null;
                    if (!workStack.isEmpty()) {
                        ni = workStack.pop();
                    } else {
                        ni = new NestedInteger();
                    }

                    if (ni.isInteger()
                        || ni.getList() != null && !ni.getList().isEmpty()
                        || i > 0) {
                        ni.add(new NestedInteger(num));
                    } else {
                        ni.setInteger(num);
                    }
                    workStack.push(ni);
                    if (i == _s.length()) {
                        return ni;
                    }
                }
            }
        }
        return result;
    }

}
