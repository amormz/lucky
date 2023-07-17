package pers.zymir.lucky.domain.strategy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class AwardRateDTO {
    private Long awardId;

    private BigDecimal awardRate;
}
