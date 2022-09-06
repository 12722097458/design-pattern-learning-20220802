package com.ityj.design.iterator;

public interface Aggregate<T> {
    void add(T t);
    Iterator<T> getIterator();
}
