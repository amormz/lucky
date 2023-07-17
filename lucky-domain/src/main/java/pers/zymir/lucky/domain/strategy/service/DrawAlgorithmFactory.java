package pers.zymir.lucky.domain.strategy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DrawAlgorithmFactory {

    private static final Map<Integer, IDrawAlgorithm> MAPPING = new HashMap<>();

    @Autowired
    private DrawAlgorithmFactory(List<IDrawAlgorithm> drawAlgorithms) {
        for (IDrawAlgorithm drawAlgorithm : drawAlgorithms) {
            MAPPING.put(drawAlgorithm.getAlgorithmType(), drawAlgorithm);
        }
    }

    public static IDrawAlgorithm getDrawAlgorithmByCode(Integer code) {
        return MAPPING.get(code);
    }
}
