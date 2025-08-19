package com.ityj.demo.tech.copy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.beans.BeanCopier;

@Slf4j
public class ShallowCopyTest {

    // https://www.infoworld.com/article/2077578/how-to-copy-objects-in-java-shallow-copy-and-deep-copy.html
    //https://www.bilibili.com/video/BV1Sa41127pU/?spm_id_from=333.337.search-card.all.click&vd_source=b23569b676ce26126febad3c290b16e8
    // https://zhuanlan.zhihu.com/p/529280783
    /*
    *   1. org.springframework.beans.BeanUtils.copyProperties
    *   2. org.apache.commons.beanutils.BeanUtils.copyProperties
    *   3. object.clone()
    *   4. Cglib BeanCopier进行属性拷贝  -  springframework和cglib性能比较好 https://developer.aliyun.com/ask/315548
    *
    * */
    @Test
    public void testSpringBeanUtilCopy() {
        StudentEntity source = new StudentEntity("Jack", 22, new Address("HeNan", 1));
        StudentEntity clone = new StudentEntity();
        org.springframework.beans.BeanUtils.copyProperties(source, clone);
        //org.apache.commons.beanutils.BeanUtils.copyProperties(clone, source);
        log.info("(clone == source) = {}", (clone == source));  // false 两个对象是不同的
        log.info("(clone == source) = {}", (clone.getAddress() == source.getAddress()));  // true 引用是一样的
        log.info("(clone == source) = {}", (clone.getName() == source.getName()));  // true 引用是一样的
        log.info("(clone == source) = {}", (clone.getAge() == source.getAge()));  // true 引用是一样的
        print(source, clone);

        System.out.println("set name = JJJJJJ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        source.setName("JJJJJJ");
        print(source, clone);
        log.info("(clone == source) = {}", (clone.getName() == source.getName()));  // false 字符串是final修饰

        System.out.println("set address = ShangHai ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        source.getAddress().setAddress("ShangHai");
        log.info("(clone == source) = {}", (clone.getAddress() == source.getAddress()));  // true 同一个引用
        print(source, clone);
    }

    private void print(StudentEntity source, StudentEntity target) {
        log.info("source: {}", source);
        log.info("clone : {}", target);
    }

    public static void copy(Class source, Class target) {
        BeanCopier.create(source.getClass(), target.getClass(), false).copy(source, target, null);
    }

}
