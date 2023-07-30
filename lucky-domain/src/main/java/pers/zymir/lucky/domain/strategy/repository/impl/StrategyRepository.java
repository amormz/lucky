package pers.zymir.lucky.domain.strategy.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.zymir.lucky.dao.StrategyDetailMapper;
import pers.zymir.lucky.dao.StrategyMapper;
import pers.zymir.lucky.domain.strategy.model.dto.StrategyConfigDTO;
import pers.zymir.lucky.domain.strategy.repository.IStrategyRepository;
import pers.zymir.lucky.po.Strategy;
import pers.zymir.lucky.po.StrategyDetail;

import java.util.List;

@Repository
public class StrategyRepository implements IStrategyRepository {

    @Autowired
    private StrategyMapper strategyMapper;

    @Autowired
    private StrategyDetailMapper strategyDetailMapper;

    @Override
    public StrategyConfigDTO queryStrategyConfig(Long strategyId) {
        LambdaQueryWrapper<Strategy> strategyLambdaQueryWrapper = Wrappers.lambdaQuery(Strategy.class)
                .eq(Strategy::getStrategyId, strategyId);
        Strategy strategy = strategyMapper.selectOne(strategyLambdaQueryWrapper);

        LambdaQueryWrapper<StrategyDetail> strategyDetailLambdaQueryWrapper = Wrappers.lambdaQuery(StrategyDetail.class)
                .eq(StrategyDetail::getStrategyId, strategyId);
        List<StrategyDetail> strategyDetails = strategyDetailMapper.selectList(strategyDetailLambdaQueryWrapper);

        StrategyConfigDTO strategyConfigDTO = new StrategyConfigDTO();
        strategyConfigDTO.setStrategy(strategy);
        strategyConfigDTO.setStrategyDetails(strategyDetails);
        return strategyConfigDTO;
    }
}
