package pers.zymir.lucky.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.zymir.lucky.enums.StrategyGrantTypeEnum;
import pers.zymir.lucky.enums.StrategyModeEnum;

@Data
@EqualsAndHashCode(callSuper = true)
public class Strategy extends BaseEntity {
    private Long id;

    private Long strategyId;

    /**
     * 策略描述
     */
    private String strategyDescription;

    /**
     * 中奖概率计算方式
     * {@link StrategyModeEnum#getCode()}
     */
    private Integer strategyMode;

    /**
     * 奖品发放模式
     * {@link StrategyGrantTypeEnum#getCode()}
     */
    private Integer grantType;

    /**
     * 拓展信息
     */
    private String extInfo;

}
