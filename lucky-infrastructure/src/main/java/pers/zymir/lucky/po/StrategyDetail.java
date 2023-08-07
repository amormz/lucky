package pers.zymir.lucky.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class StrategyDetail extends BaseEntity {
    private Long id;

    /**
     * 所属策略id
     */
    private Long strategyId;

    /**
     * 奖品id
     */
    private Long awardId;

    /**
     * 当前奖品数量
     */
    private Long awardCount;

    /**
     * 奖品中奖概率
     */
    private BigDecimal awardRate;

    /**
     * 奖品剩余库存数量
     */
    private Long residualInventory;
}
