package pers.zymir.lucky.domain.activity.model.req;

import lombok.Data;
import pers.zymir.lucky.domain.activity.model.dto.ActivityCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.AwardCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.StrategyCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.StrategyDetailCreateDTO;

import java.util.List;

@Data
public class ActivityDeployReq {
    private Long activityId;
    private ActivityCreateDTO activityCreateDTO;
    private List<AwardCreateDTO> awardCreateDTOList;
    private StrategyCreateDTO strategyCreateDTO;
    private List<StrategyDetailCreateDTO> strategyDetailCreateDTO;
}
