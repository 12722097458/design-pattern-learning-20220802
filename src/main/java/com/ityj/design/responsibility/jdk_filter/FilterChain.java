package com.ityj.design.responsibility.jdk_filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {

    private List<Filter> filters = new ArrayList<>();
    private int index = 0;

    public FilterChain addFilter(Filter filter) {
        if (filter != null) {
            this.filters.add(filter);
        }
        return this;
    }

    public void doFilter(Request request, Response response) {
        if (index != filters.size()) {
            Filter filter = filters.get(index++);
            filter.doFilter(request, response, this);
        }
    }
}
