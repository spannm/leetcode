package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Problem0631 extends LeetcodeProblem {

    static class Excel {

        private final Formula[][]  formulas;

        private final Stack<int[]> stack = new Stack<>();

        Excel(int _h, char _w) {
            formulas = new Formula[_h][_w - 'A' + 1];
        }

        int get(int _r, char _c) {
            if (formulas[_r - 1][_c - 'A'] == null) {
                return 0;
            }
            return formulas[_r - 1][_c - 'A'].val;
        }

        void set(int _r, char _c, int _v) {
            formulas[_r - 1][_c - 'A'] = new Formula(new HashMap<>(), _v);
            topologicalSort(_r - 1, _c - 'A');
            executeStack();
        }

        int sum(int _r, char _c, String[] _strs) {
            Map<String, Integer> cells = convert(_strs);
            int summ = calculateSum(_r - 1, _c - 'A', cells);
            set(_r, _c, summ);
            formulas[_r - 1][_c - 'A'] = new Formula(cells, summ);
            return summ;
        }

        void topologicalSort(int _r, int _c) {
            for (int i = 0; i < formulas.length; i++) {
                for (int j = 0; j < formulas[0].length; j++) {
                    if (formulas[i][j] != null && formulas[i][j].cells.containsKey("" + (char) ('A' + _c) + (_r + 1))) {
                        topologicalSort(i, j);
                    }
                }
            }
            stack.push(new int[] {_r, _c});
        }

        void executeStack() {
            while (!stack.isEmpty()) {
                int[] top = stack.pop();
                if (!formulas[top[0]][top[1]].cells.isEmpty()) {
                    calculateSum(top[0], top[1], formulas[top[0]][top[1]].cells);
                }
            }
        }

        Map<String, Integer> convert(String[] _strs) {
            Map<String, Integer> res = new HashMap<>();
            for (String st : _strs) {
                if (!st.contains(":")) {
                    res.put(st, res.getOrDefault(st, 0) + 1);
                } else {
                    String[] cells = st.split(":");
                    int si = Integer.parseInt(cells[0].substring(1));
                    int ei = Integer.parseInt(cells[1].substring(1));
                    char sj = cells[0].charAt(0);
                    char ej = cells[1].charAt(0);
                    for (int i = si; i <= ei; i++) {
                        for (char j = sj; j <= ej; j++) {
                            res.put("" + j + i, res.getOrDefault("" + j + i, 0) + 1);
                        }
                    }
                }
            }
            return res;
        }

        int calculateSum(int _r, int _c, Map<String, Integer> _cells) {
            int sum = 0;
            for (String s : _cells.keySet()) {
                int x = Integer.parseInt(s.substring(1)) - 1;
                int y = s.charAt(0) - 'A';
                sum += (formulas[x][y] != null ? formulas[x][y].val : 0) * _cells.get(s);
            }
            formulas[_r][_c] = new Formula(_cells, sum);
            return sum;
        }

        static class Formula {
            private final Map<String, Integer> cells;
            private final int                  val;

            Formula(Map<String, Integer> _c, int _v) {
                val = _v;
                cells = _c;
            }
        }
    }

}
