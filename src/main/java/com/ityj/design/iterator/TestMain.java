package com.ityj.design.iterator;

/*
*   迭代器模式
* */
public class TestMain {
    public static void main(String[] args) {

        StudentAggregate studentAggregate = new StudentAggregate();
        studentAggregate.add(new Student("Jack"));
        studentAggregate.add(new Student("Jack2"));
        studentAggregate.add(new Student("Jack3"));
        Iterator<Student> iterator = studentAggregate.getIterator();
        while (iterator.hasNext()) {
            System.out.println("iterator = " + iterator.next());
        }
    }
}
