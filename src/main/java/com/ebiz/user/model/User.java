package com.ebiz.user.model;

import com.ebiz.user.commons.validation.UserLogin;
import com.ebiz.user.commons.validation.UserSave;
import com.ebiz.user.commons.validation.UserUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author EBIZ
 */
@Component
@ToString
public class User {
    @NotNull(message = "id不能为空",
            groups = {
                    UserUpdate.class,
            }
    )
    @Min(value = 1, message = "id不能小于0",
            groups = {
                    UserUpdate.class
            }
    )
    private Integer id;

    @NotNull(message = "名字不能为空",
            groups = {
                    UserLogin.class,
                    UserSave.class,
                    UserUpdate.class,
            }
    )
    private String username;

    @NotNull(message = "密码不能为空",
            groups = {
                    UserSave.class,
            }
    )
    @Size(min = 8, max = 20, message = "密码长度不小于8并且不大于20",
            groups = {
                    UserLogin.class,
                    UserSave.class,
                    UserUpdate.class,
            }
    )
    private String password;

    private String createdUser;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    private String modifiedUser;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedDate;

    @JsonIgnore
    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser == null ? null : createdUser.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser == null ? null : modifiedUser.trim();
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}