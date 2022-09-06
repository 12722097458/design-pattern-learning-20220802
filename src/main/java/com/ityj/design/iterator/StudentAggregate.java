package com.ityj.design.iterator;

import java.util.ArrayList;
import java.util.List;


public class StudentAggregate implements Aggregate<Student> {

    private List<Student> list = new ArrayList<>();

    @Override
    public void add(Student student) {
        list.add(student);
    }

    @Override
    public Iterator<Student> getIterator() {
        return new StudentIterator(list);
    }
}
