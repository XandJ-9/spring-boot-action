package com.xujia.service;

import com.xujia.entity.Account;

public interface AccountService {
    public Account findByUsername(String username);
}
