package com.xujia;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xujia.entity.Account;
import com.xujia.mapper.AccountMapper;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit test for simple App.
 */

@SpringBootTest
public class AccountMapperTest
{
    @Autowired
    private AccountMapper accountMapper;


    @Test
    public void test(){
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("username", "zs");
        Account account = accountMapper.selectOne(wrapper);
        System.out.println(account);
    }
}
