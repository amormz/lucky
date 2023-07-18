package pers.zymir.lucky.domain.strategy.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.zymir.lucky.dao.StrategyDAO;
import pers.zymir.lucky.dao.StrategyDetailDAO;
import pers.zymir.lucky.domain.strategy.model.dto.StrategyConfigDTO;
import pers.zymir.lucky.domain.strategy.repository.IStrategyRepository;
import pers.zymir.lucky.po.Strategy;
import pers.zymir.lucky.po.StrategyDetail;

import java.util.List;

@Repository
public class StrategyRepository implements IStrategyRepository {

    @Autowired
    private StrategyDAO strategyDAO;

    @Autowired
    private StrategyDetailDAO strategyDetailDAO;

    @Override
    public StrategyConfigDTO queryStrategyConfig(Long strategyId) {
        Strategy strategy = strategyDAO.selectByStrategyId(strategyId);
        List<StrategyDetail> strategyDetails = strategyDetailDAO.selectByStrategyId(strategyId);

        StrategyConfigDTO strategyConfigDTO = new StrategyConfigDTO();
        strategyConfigDTO.setStrategy(strategy);
        strategyConfigDTO.setStrategyDetails(strategyDetails);
        return strategyConfigDTO;
    }
}
