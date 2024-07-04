package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.HtmlParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1236. Web Crawler.
 */
class Problem1236 extends LeetcodeProblem {

    private Set<String> ans;

    List<String> crawl(String _startUrl, HtmlParser _htmlParser) {
        ans = new HashSet<>();
        dfs(_startUrl, _htmlParser);
        return new ArrayList<>(ans);
    }

    private void dfs(String _url, HtmlParser _htmlParser) {
        if (ans.contains(_url)) {
            return;
        }
        ans.add(_url);
        for (String next : _htmlParser.getUrls(_url)) {
            if (host(next).equals(host(_url))) {
                dfs(next, _htmlParser);
            }
        }
    }

    private String host(String _url) {
        _url = _url.substring(7);
        return _url.split("/")[0];
    }

}
