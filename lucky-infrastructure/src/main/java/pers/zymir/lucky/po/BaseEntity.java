package pers.zymir.lucky.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;

import java.util.Date;

@Getter
public class BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;
}
