package com.ityj.design.prototype;

/*
*   原型模式实现浅克隆
*
* */
public class TestMain {
    public static void main(String[] args) throws CloneNotSupportedException {

        /*
            浅克隆：创建一个新的对象，对象的属性和原来对象完全相同。对于非基本类型属性，仍指向原有属性所指向对象的内存地址
        *   Clone 是浅克隆， Award对象会生产一个新的，但是其属性是同一个，指向同一个地址
        *
        * */

        Student jack = new Student();
        jack.setName("Jack");
        Award award = new Award();
        award.setStudent(jack);

        Award clone = award.clone();
        clone.getStudent().setName("Rose");


        System.out.println(award == clone);
        System.out.println(award.getStudent() == clone.getStudent());
        award.show();
        clone.show();

    }
}
