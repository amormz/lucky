package pers.zymir.lucky.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pers.zymir.lucky.po.Strategy;

@Mapper
public interface StrategyDAO {
    String TABLE_NAME = "strategy";

    @Select(
            "select * from " + TABLE_NAME + " where strategy_id = #{strategyId} "
    )
    Strategy selectByStrategyId(@Param("strategyId") Long strategyId);
}
