package com.example.demo.mapper;

import com.example.demo.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AccountMapper继承基类
 */
@Repository
public interface AccountMapper extends MyBatisBaseDao<Account, Integer, AccountExample> {

	List<Account> selectByPermission();


	Account findByLoginAndPassword(String loginName, String password);
}