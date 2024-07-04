package io.github.spannm.leetcode;

/**
 * Unspecific {@code Leetcode} run-time exception.
 */
public final class LeetcodeRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LeetcodeRuntimeException(String _message) {
        this(_message, null);
    }

    public LeetcodeRuntimeException(Throwable _cause) {
        this(null, _cause);
    }

    public LeetcodeRuntimeException(String _message, Throwable _cause) {
        super(_message, _cause);
    }

    public static LeetcodeRuntimeException from(Throwable _ex) {
        return _ex instanceof LeetcodeRuntimeException ? (LeetcodeRuntimeException) _ex : new LeetcodeRuntimeException(_ex);
    }

}
