package pers.zymir.lucky.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AwardTypeEnum implements MappableEnums {
    COUPON(1, "优惠券"),
    CDK(2, "CDK兑换码"),
    PHYSICAL_PRIZES(3, "实物奖品");

    private final int code;

    private final String description;

    @Override
    public Integer getCode() {
        return code;
    }
}
