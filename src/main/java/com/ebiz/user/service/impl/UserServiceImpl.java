package com.ebiz.user.service.impl;

import com.ebiz.user.commons.enums.IsDeleteEnum;
import com.ebiz.user.dao.UserDAO;
import com.ebiz.user.model.User;
import com.ebiz.user.model.UserExample;
import com.ebiz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author dhl
 * @datetime 2021/8/12  17:41
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public User getUserById(Integer id) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(id).andIsDeleteEqualTo(0);
        List<User> users = userDAO.selectByExample(userExample);
        return !CollectionUtils.isEmpty(users) ? users.get(0) : null;
    }

    @Override
    public List<User> listUsers() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIsNotNull().andIsDeleteEqualTo(0);
        return userDAO.selectByExample(userExample);
    }

    @Override
    public int saveUser(User user) {
        return userDAO.insertSelective(user);
    }

    @Override
    public int deleteUser(User user) {
        user.setIsDelete(IsDeleteEnum.getCodeByMessage("已删除"));
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(user.getId());
        return userDAO.updateByExample(user, userExample);
    }

    @Override
    public int updateUser(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(user.getId());
        return userDAO.updateByExampleSelective(user, userExample);
    }

    @Override
    public User loginAuthentication(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername())
                .andPasswordEqualTo(user.getPassword());
        List<User> users = userDAO.selectByExample(userExample);
        return !CollectionUtils.isEmpty(users) ? users.get(0) : null;
    }

}