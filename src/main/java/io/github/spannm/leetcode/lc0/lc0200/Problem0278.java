package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/first-bad-version/">278. First Bad Version</a>.
 */
public abstract class Problem0278 extends LeetcodeProblem {

    abstract boolean isBadVersionImpl(int _version);

    boolean isBadVersion(int _version) {
        boolean bad = isBadVersionImpl(_version);
        return bad;
    }

    int firstBadVersion(int _nbVersions) {

        int fromVersion = 1;
        int toVersion = _nbVersions;

        int minBadVersion = toVersion;
        while (fromVersion <= toVersion) {
            int checkVersion = fromVersion + (toVersion - fromVersion) / 2;
            if (isBadVersion(checkVersion)) {
                minBadVersion = Math.min(minBadVersion, checkVersion);
                toVersion = checkVersion - 1;
            } else {
                fromVersion = checkVersion + 1;
            }
        }
        return minBadVersion;
    }

}
