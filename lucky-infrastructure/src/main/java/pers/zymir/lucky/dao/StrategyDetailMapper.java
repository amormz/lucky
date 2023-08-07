package pers.zymir.lucky.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import pers.zymir.lucky.po.StrategyDetail;

@Mapper
public interface StrategyDetailMapper extends BaseMapper<StrategyDetail> {

    String TABLE = "strategy_detail";

    @Update("""
            update strategy_detail set   residual_inventory = residual_inventory - 1  where strategy_id = #{strategyId} and  award_id = #{awardId} and residual_inventory > 0
            """)
    int deductionInventory(@Param("strategyId") Long strategyId, @Param("awardId") Long awardId);
}
