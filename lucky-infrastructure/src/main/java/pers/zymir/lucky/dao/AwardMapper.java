package pers.zymir.lucky.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.zymir.lucky.po.Award;

import java.util.List;

@Mapper
public interface AwardMapper extends BaseMapper<Award> {

    @Insert(
            """
                    <script>
                        insert into award (award_id, award_count, award_name ) values
                            <foreach collection='awards' item='item' separator=','>
                                (#{item.awardId}, #{item.awardCount}, #{item.awardName})
                            </foreach>
                    </script>
                    """
    )
    void batchInsert(@Param("awards") List<Award> awards);
}
