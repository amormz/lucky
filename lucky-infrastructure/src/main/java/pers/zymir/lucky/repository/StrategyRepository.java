package pers.zymir.lucky.repository;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.zymir.lucky.dao.StrategyDetailMapper;
import pers.zymir.lucky.dao.StrategyMapper;
import pers.zymir.lucky.domain.strategy.model.dto.StrategyConfigDTO;
import pers.zymir.lucky.domain.strategy.model.dto.StrategyDTO;
import pers.zymir.lucky.domain.strategy.model.dto.StrategyDetailDTO;
import pers.zymir.lucky.domain.strategy.repository.IStrategyRepository;
import pers.zymir.lucky.po.Strategy;
import pers.zymir.lucky.po.StrategyDetail;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class StrategyRepository implements IStrategyRepository {

    @Autowired
    private StrategyMapper strategyMapper;

    @Autowired
    private StrategyDetailMapper strategyDetailMapper;

    /**
     * 根据策略ID查询抽奖策略配置
     *
     * @param strategyId 策略ID
     * @return 抽奖策略配置
     */
    @Override
    public StrategyConfigDTO queryStrategyConfig(Long strategyId) {
        LambdaQueryWrapper<Strategy> strategyLambdaQueryWrapper = Wrappers.lambdaQuery(Strategy.class)
                .eq(Strategy::getStrategyId, strategyId);
        Strategy strategy = strategyMapper.selectOne(strategyLambdaQueryWrapper);

        LambdaQueryWrapper<StrategyDetail> strategyDetailLambdaQueryWrapper = Wrappers.lambdaQuery(StrategyDetail.class)
                .eq(StrategyDetail::getStrategyId, strategyId);
        List<StrategyDetail> strategyDetails = strategyDetailMapper.selectList(strategyDetailLambdaQueryWrapper);

        StrategyConfigDTO strategyConfigDTO = new StrategyConfigDTO();
        strategyConfigDTO.setStrategy(BeanUtil.toBean(strategy, StrategyDTO.class));
        strategyConfigDTO.setStrategyDetails(BeanUtil.copyToList(strategyDetails, StrategyDetailDTO.class));
        return strategyConfigDTO;
    }

    @Override
    public int deductionInventory(Long strategyId, Long awardId) {
        return strategyDetailMapper.deductionInventory(strategyId, awardId);
    }

    @Override
    public Set<Long> queryEmptyInventoryAwardIds(Long strategyId) {
        LambdaQueryWrapper<StrategyDetail> queryWrapper = Wrappers.lambdaQuery(StrategyDetail.class)
                .eq(StrategyDetail::getStrategyId, strategyId);
        List<StrategyDetail> strategyDetails = strategyDetailMapper.selectList(queryWrapper);
        return strategyDetails.stream().filter(detail -> detail.getResidualInventory() <= 0).map(StrategyDetail::getAwardId).collect(Collectors.toSet());
    }
}
