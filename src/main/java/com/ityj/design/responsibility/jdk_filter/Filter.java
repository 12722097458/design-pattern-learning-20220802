package com.ityj.design.responsibility.jdk_filter;
public interface Filter {

     void doFilter(Request request, Response response, FilterChain filterChain);

}