package com.emirhanuzun.aopdemo.dao;

import com.emirhanuzun.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " : DOING MY DB WORK. ADDING AN ACCOUNT");
    }


}
