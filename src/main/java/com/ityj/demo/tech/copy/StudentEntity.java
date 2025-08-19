package com.ityj.demo.tech.copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    private String name;
    private Integer age;
    private Address address;


    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", age='" + age + '\'' +
                ", address=" + address +
                ", hashCode(): =" + this.hashCode() +
                '}';
    }

}
