package io.github.spannm.leetcode;

public abstract class LeetcodeSqlProblem extends LeetcodeProblem {

    private final String sql;

    protected LeetcodeSqlProblem(String _sql) {
        sql = _sql;
    }

    @Override
    public String toString() {
        return String.format("%s[sql=%s]", getClass().getSimpleName(), sql);
    }

}
