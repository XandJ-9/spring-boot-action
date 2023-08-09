package com.xujia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xujia.entity.Account;
import com.xujia.mapper.AccountMapper;
import com.xujia.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account findByUsername(String username) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return accountMapper.selectOne(wrapper);
    }
}
