package pers.zymir.lucky.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pers.zymir.lucky.po.StrategyDetail;

import java.util.List;

@Mapper
public interface StrategyDetailDAO {
    String TABLE_NAME = "strategy_detail";

    @Select(
            " select * from " + TABLE_NAME + " where strategy_id = #{strategyId} "
    )
    List<StrategyDetail> selectByStrategyId(@Param("strategyId") Long strategyId);
}
