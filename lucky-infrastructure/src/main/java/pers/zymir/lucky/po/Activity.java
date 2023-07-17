package pers.zymir.lucky.po;

import lombok.Data;
import pers.zymir.lucky.enums.ActivityStateEnum;

@Data
public class Activity {

    private Long id;

    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动描述
     */
    private String activityDescription;

    /**
     * 活动开始时间戳
     */
    private Long startTimestamp;

    /**
     * 活动结束时间戳
     */
    private Long endTimestamp;

    /**
     * 活动总库存
     */
    private Integer stockCount;

    /**
     * 活动当前剩余库存
     */
    private Integer residueStockCount;

    /**
     * 活动状态
     * {@link ActivityStateEnum#getCode()}
     */
    private Integer state;

    /**
     * 活动创建人
     */
    private String creator;
}
