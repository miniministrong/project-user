package com.ebiz.user.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * @author dhl
 * @datetime 2021/8/13  16:14
 */
@Data
@Component
public class Page {
    /**
     * 页码
     */
    @NotNull(message = "页码不能为空")
    private Integer PageNum;
    /**
     * 每页的条数
     */
    @NotNull(message = "每页的数量不能为空")
    private Integer pageSize;
}