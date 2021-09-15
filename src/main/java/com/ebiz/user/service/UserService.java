package com.ebiz.user.service;

import com.ebiz.user.model.User;

import java.util.List;

/**
 * @author dhl
 * @datetime 2021/8/12  17:39
 */
public interface UserService {
    /**
     * 通过id查找用户对象
     * @param id
     * @return 用户对象
     */
    User getUserById(Integer id);

    /**
     * 查询所有用户对象转换为一个集合
     * @return 用户对象所在的集合
     */
    List<User> listUsers();

    /**
     * 新增用户
     * @param user 用户的所有数据
     * @return 用户成功与否的信息
     */
    int saveUser(User user);

    /**
     * 通过id删除用户信息
     * @param user
     * @return 成功信息
     */
    int deleteUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return 更新信息结果
     */
    int updateUser(User user);

    /**
     * 验证用户名和密码是否正确
     * @param user
     * @return user对象
     */
    User loginAuthentication(User user);
}
