package pers.zymir.lucky.domain.activity.repository;

import pers.zymir.lucky.domain.activity.model.dto.ActivityCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.AwardCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.StrategyCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.StrategyDetailCreateDTO;

import java.util.List;

public interface IActivityRepository {

    void addActivity(ActivityCreateDTO activityCreateDTO);

    long addStrategy(StrategyCreateDTO strategyCreateDTO);

    void addAwards(List<AwardCreateDTO> awardCreateDTOs);

    void addStrategyDetail(List<StrategyDetailCreateDTO> strategyDetailCreateDTOs);
}
