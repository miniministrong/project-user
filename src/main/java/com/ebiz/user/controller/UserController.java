package com.ebiz.user.controller;

import com.ebiz.user.commons.util.DozerUtils;
import com.ebiz.user.commons.util.ResultModel;
import com.ebiz.user.commons.validation.UserSave;
import com.ebiz.user.dto.UserDTO;
import com.ebiz.user.model.Page;
import com.ebiz.user.model.User;
import com.ebiz.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author dhl
 * @datetime 2021/8/12  17:08
 */
@Validated
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResultModel saveUser(@Validated({UserSave.class}) @RequestBody User user){
        user.setCreatedUser(user.getUsername());
        user.setCreatedDate(new Date());
        user.setModifiedUser(user.getUsername());
        user.setModifiedDate(new Date());
        user.setIsDelete(0);
        userService.saveUser(user);
        HashMap resultMap = new HashMap();
        resultMap.put("saveUserInfo", user.getId());
        return ResultModel.success(resultMap);
    }

    @GetMapping("/getUserById")
    public ResultModel getUserById(@NotNull(message = "传递的id不能为空") @Min(value = 1, message = "传递的参数必须大于0") Integer id){
        User user = userService.getUserById(id);
        if (user == null) {
            return ResultModel.error(400, "您查询的数据不存在！");
        }
        HashMap resultMap = new HashMap();
        resultMap.put("getUserInfo", user);
        return ResultModel.success(resultMap);
    }

    @GetMapping("/delUser")
    public ResultModel deleteUser(@NotNull(message = "传递的id不能为空") @Min(value = 1, message = "传递的参数必须大于0") Integer id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResultModel.error(400, "您删除的数据不存在，请添加后再进行删除操作！");
        }
        user.setModifiedUser(user.getUsername());
        user.setModifiedDate(new Date());
        int deleteUserCount = userService.deleteUser(user);
        Map resultMap = new HashMap();
        resultMap.put("delUserCount", deleteUserCount);
        return ResultModel.success(resultMap);
    }

    @PostMapping("/updateUser")
    public ResultModel updateUser(@Validated @RequestBody User user){
        user.setModifiedUser(user.getUsername());
        user.setModifiedDate(new Date());
        if (user == null) {
            return ResultModel.error(400, "您的信息为空，请重新输入");
        }
        int i = userService.updateUser(user);
        Map resultMap = new HashMap();
        resultMap.put("updateUserInfo", i);
        return ResultModel.success(resultMap);
    }

    @PostMapping("/listUsers")
    public ResultModel listUsers(@RequestBody Page page){
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<User> users = userService.listUsers();
        if (users == null) {
            return ResultModel.error(-1, "数据库错误，请重试");
        }
        PageInfo<User> pageInfo = new PageInfo<>(users);
        Map resultMap = new HashMap();
        resultMap.put("listUsersInfo", pageInfo.getList());
        return ResultModel.success(resultMap);
    }

    @GetMapping("/getUser")
    public ResultModel getUserDozer(@NotNull(message = "传递的id不能为空")
                               @Min(value = 1, message = "传递的参数必须大于0") Integer id){
        User user = userService.getUserById(id);
        if (user == null) {
            return ResultModel.error("查询失败");
        }
        UserDTO userDTO = DozerUtils.map(user, UserDTO.class);
        Map resultMap = new HashMap();
        resultMap.put("userInfo", userDTO);
        return ResultModel.success("查询成功", resultMap);
    }

    @PostMapping("/listUsersDozer")
    public ResultModel listUsersPageDozer(@RequestBody Page page){
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<User> users = userService.listUsers();
        if (users == null) {
            return ResultModel.error("您的查询有误，请稍后再试");
        }
        List<UserDTO> userDTOS = DozerUtils.mapList(users, UserDTO.class);
        Map resultMap = new HashMap();
        resultMap.put("userListInfo", userDTOS);
        return ResultModel.success("查询成功", resultMap);
    }

}