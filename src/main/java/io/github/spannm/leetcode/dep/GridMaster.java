package io.github.spannm.leetcode.dep;

@SuppressWarnings({"PMD.ClassNamingConventions", "checkstyle:TypeNameCheck"})
public interface GridMaster {
    boolean canMove(char _d);

    int move(char _d);

    boolean isTarget();
}
