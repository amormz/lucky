package pers.zymir.lucky.po;

import lombok.Getter;

import java.util.Date;

@Getter
public class BaseEntity {
    private Date createTime;

    private Date updateTime;

    private Boolean deleted;
}
