package pers.zymir.lucky.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ActivityStateEnum implements MappableEnums {

    EDIT(1, "编辑中"),
    SUBMIT_REVIEW(2, "提审"),
    REVOCATION_REVIEW(3, "撤销编辑"),
    PASS(4, "通过"),
    RUNNING(5, "运行中"),
    REFUSE(6, "拒绝"),
    CLOSE(7, "关闭"),
    OPEN(8, "开启");

    @Getter
    private final Integer code;

    private final String description;

    @Override
    public Integer getCode() {
        return code;
    }
}
