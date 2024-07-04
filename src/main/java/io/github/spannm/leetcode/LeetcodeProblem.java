package io.github.spannm.leetcode;

public abstract class LeetcodeProblem {

    @Override
    public String toString() {
        return String.format("%s[]", getClass().getSimpleName());
    }

    public static String asString(Object _o) {
        if (_o == null) {
            return "null";
        } else if (_o.getClass().isArray()) {
            final int len = java.lang.reflect.Array.getLength(_o);
            Object[] arr = new Object[len];
            for (int i = 0; i < len; i++) {
                arr[i] = java.lang.reflect.Array.get(_o, i);
            }
            return "["
                + java.util.Arrays.stream(arr)
                    .map(LeetcodeProblem::asString)
                    .collect(java.util.stream.Collectors.joining(","))
                + "]";
        }
        return _o.toString();
    }

}
