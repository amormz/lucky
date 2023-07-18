package pers.zymir.lucky.exception;

import lombok.AllArgsConstructor;
import pers.zymir.common.resp.Responsive;

@AllArgsConstructor
public enum ResultCode implements Responsive {
    SUCCESS("200", "成功"),

    DRAW_ALGORITHM_NOT_FOUND("50001", "未找到对应抽奖算法");

    private final String code;

    private final String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

