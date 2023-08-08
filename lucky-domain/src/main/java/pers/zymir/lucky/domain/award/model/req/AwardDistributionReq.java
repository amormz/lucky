package pers.zymir.lucky.domain.award.model.req;

import lombok.Data;

@Data
public class AwardDistributionReq {
    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品ID
     */
    private String awardId;

    /**
     * 中奖人ID
     */
    private Long userId;
}
