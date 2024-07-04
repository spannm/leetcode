package io.github.spannm.leetcode.dep;

import java.util.List;

@SuppressWarnings({"PMD.ClassNamingConventions", "checkstyle:TypeNameCheck"})
public interface BinaryMatrix {
    int get(int _row, int _col);

    List<Integer> dimensions();
}
