package pers.zymir.lucky.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StrategyModeEnum implements MappableEnums {

    SINGLETON(1, "单项概率"),
    MULTI(2, "总体概率");

    private final Integer code;

    private final String description;

    @Override
    public Integer getCode() {
        return code;
    }
}
