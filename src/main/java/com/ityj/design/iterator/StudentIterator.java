package com.ityj.design.iterator;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class StudentIterator implements Iterator<Student> {

    private List<Student> list;
    private int position = 0;

    public StudentIterator(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        return list.get(position++);
    }
}
