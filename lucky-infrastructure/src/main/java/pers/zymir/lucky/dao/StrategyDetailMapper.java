package pers.zymir.lucky.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import pers.zymir.lucky.po.StrategyDetail;

import java.util.List;

@Mapper
public interface StrategyDetailMapper extends BaseMapper<StrategyDetail> {

    @Update("""
            update strategy_detail set residual_inventory = residual_inventory - 1  where strategy_id = #{strategyId} and  award_id = #{awardId} and residual_inventory > 0
            """)
    int deductionInventory(@Param("strategyId") Long strategyId, @Param("awardId") Long awardId);

    @Insert(
            """
                    <script>
                        insert into strategy_detail (strategy_id, award_id, award_count, award_rate, residual_inventory) values
                            <foreach collection='strategyDetails', item='item', separator=','>
                                (#{item.strategyId}, #{item.awardId}, #{item.awardCount}, #{item.awardRate},#{item.residualInventory})
                            </foreach>
                    </script>
                    """
    )
    void batchInsert(@Param("strategyDetails") List<StrategyDetail> strategyDetails);
}
