package io.github.spannm.leetcode.dep;

import java.util.List;

@SuppressWarnings({"PMD.ClassNamingConventions", "checkstyle:TypeNameCheck"})
public interface HtmlParser {
    List<String> getUrls(String _url);
}
