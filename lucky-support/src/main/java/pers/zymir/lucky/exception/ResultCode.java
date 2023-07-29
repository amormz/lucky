package pers.zymir.lucky.exception;

import lombok.AllArgsConstructor;
import pers.zymir.basic.result.BusinessStatus;

@AllArgsConstructor
public enum ResultCode implements BusinessStatus {
    DRAW_ALGORITHM_NOT_FOUND("50001", "未找到对应抽奖算法");

    private final String code;

    private final String message;

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}

