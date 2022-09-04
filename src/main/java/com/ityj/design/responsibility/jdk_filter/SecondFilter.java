package com.ityj.design.responsibility.jdk_filter;

public class SecondFilter implements Filter {

     @Override
     public void doFilter(Request request, Response response, FilterChain filterChain) {

          System.out.println("SecondFilter.....前置处理");
          filterChain.doFilter(request, response);
          System.out.println("SecondFilter.....后置处理");

     }
}