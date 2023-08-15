package pers.zymir.lucky.repository;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.zymir.lucky.dao.ActivityMapper;
import pers.zymir.lucky.dao.AwardMapper;
import pers.zymir.lucky.dao.StrategyDetailMapper;
import pers.zymir.lucky.dao.StrategyMapper;
import pers.zymir.lucky.domain.activity.model.dto.ActivityCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.AwardCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.StrategyCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.StrategyDetailCreateDTO;
import pers.zymir.lucky.domain.activity.repository.IActivityRepository;
import pers.zymir.lucky.po.Activity;
import pers.zymir.lucky.po.Award;
import pers.zymir.lucky.po.Strategy;
import pers.zymir.lucky.po.StrategyDetail;

import java.util.List;

@Repository
public class ActivityRepository implements IActivityRepository {

    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private StrategyMapper strategyMapper;
    @Autowired
    private StrategyDetailMapper strategyDetailMapper;
    @Autowired
    private AwardMapper awardMapper;

    @Override
    public void addActivity(ActivityCreateDTO activityCreateDTO) {
        Activity activity = BeanUtil.copyProperties(activityCreateDTO, Activity.class);
        activityMapper.insert(activity);
    }

    @Override
    public long addStrategy(StrategyCreateDTO strategyCreateDTO) {
        Strategy strategy = BeanUtil.copyProperties(strategyCreateDTO, Strategy.class);
        strategyMapper.insert(strategy);
        return strategy.getStrategyId();
    }

    @Override
    public void addAwards(List<AwardCreateDTO> awardCreateDTOList) {
        List<Award> awards = BeanUtil.copyToList(awardCreateDTOList, Award.class);
        awardMapper.batchInsert(awards);
    }

    @Override
    public void addStrategyDetail(List<StrategyDetailCreateDTO> strategyDetailCreateDTOList) {
        List<StrategyDetail> strategyDetails = BeanUtil.copyToList(strategyDetailCreateDTOList, StrategyDetail.class);
        strategyDetailMapper.batchInsert(strategyDetails);
    }
}
