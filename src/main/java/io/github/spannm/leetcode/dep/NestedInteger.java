package io.github.spannm.leetcode.dep;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

    private List<NestedInteger> list;
    private Integer             integer;

    public NestedInteger(List<NestedInteger> _list) {
        list = _list;
    }

    public NestedInteger(Integer _integer) {
        integer = _integer;
    }

    public NestedInteger() {
        this(new ArrayList<>());
    }

    public void add(NestedInteger _nestedInteger) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(_nestedInteger);
    }

    public void setInteger(int _num) {
        integer = _num;
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public static String printNi(NestedInteger _thisNi, StringBuilder _sb) {
        if (_thisNi.isInteger()) {
            _sb.append(_thisNi.integer)
               .append(",");
        }
        _sb.append("[");
        for (NestedInteger ni : _thisNi.list) {
            if (ni.isInteger()) {
                _sb.append(ni.integer)
                   .append(",");
            } else {
                printNi(ni, _sb);
            }
        }
        _sb.append("]");
        return _sb.toString();
    }

}
