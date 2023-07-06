package com.xujia.demo.quickstart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xujia.demo.quickstart.domain.User;

/**
 * 继承mybatis-plus提供的 BaseMapper接口，传入具体的对象类型，
 * 由框架来实现针对对象的一系列增删改查的操作
 */
public interface UserMapper extends BaseMapper<User> {
}
