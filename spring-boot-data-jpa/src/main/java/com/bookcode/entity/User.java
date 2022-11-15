package com.bookcode.entity;


import javax.persistence.*;

@Entity  // 注解数据实体类
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // 采用自增策略增加id值
    private Long id;

    private String firstName;

    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {

        return String.format("User[id='%d', firstName='%s', lastName='%s']",id, firstName, lastName);
    }

    // 空构造函数
    public User(){}



}
