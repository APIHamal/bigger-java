package com.lizhengpeng.bigger.java;

import java.util.List;

/**
 * @Author liuguanyi
 * @Date 2025/1/26 上午10:57
 **/
public interface IUserDao {
	List<User> fetchAll(Long id);
}
