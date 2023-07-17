package pers.zymir.lucky.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StrategyGrantTypeEnum implements MappableEnums {
    IMMEDIATELY(1, "立即发奖"),
    SCHEDULE(2, "定时[包含活动结束]"),
    MANUAL(2, "人工手动发奖");

    private final Integer code;

    private final String description;

    @Override
    public Integer getCode() {
        return code;
    }
}
