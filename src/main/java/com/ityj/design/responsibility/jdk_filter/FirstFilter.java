package com.ityj.design.responsibility.jdk_filter;

public class FirstFilter implements Filter {

     @Override
     public void doFilter(Request request, Response response, FilterChain filterChain) {

          System.out.println("FirstFilter.....前置处理");
          filterChain.doFilter(request, response);
          System.out.println("FirstFilter.....后置处理");

     }
}