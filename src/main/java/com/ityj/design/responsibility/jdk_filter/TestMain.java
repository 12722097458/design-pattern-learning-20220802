package com.ityj.design.responsibility.jdk_filter;

/*
*   JDK中的filter就是通过责任链模式实现的
*
* */
public class TestMain {
    public static void main(String[] args) {
        Request request = null;
        Response response = null;
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new FirstFilter()).addFilter(new SecondFilter());
        filterChain.doFilter(request, response);
    }
}
