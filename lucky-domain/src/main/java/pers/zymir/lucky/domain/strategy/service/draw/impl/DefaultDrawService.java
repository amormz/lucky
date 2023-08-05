package pers.zymir.lucky.domain.strategy.service.draw.impl;

import org.springframework.stereotype.Service;
import pers.zymir.lucky.domain.strategy.service.draw.AbstractDrawService;

import java.util.HashSet;
import java.util.Set;

@Service
public class DefaultDrawService extends AbstractDrawService {
    @Override
    protected Set<Long> queryExcludeAwardIds(Long strategyId) {
        return new HashSet<>();
    }
}
