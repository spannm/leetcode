package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem2408 extends LeetcodeProblem {

    static class SQL {

        private final List<Integer>                   columns;
        private final Map<String, List<List<String>>> tables;

        SQL(List<String> _names, List<Integer> _columns) {
            columns = _columns;
            tables = new HashMap<>(_names.size());
        }

        void insertRow(String name, List<String> row) {
            tables.computeIfAbsent(name, k -> new ArrayList<>()).add(row);
        }

        void deleteRow(String name, int rowId) {
        }

        String selectCell(String name, int rowId, int columnId) {
            return tables.get(name).get(rowId - 1).get(columnId - 1);
        }

        List<Integer> getColumns() {
            return columns;
        }

    }

}
