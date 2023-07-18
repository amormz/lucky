package pers.zymir.lucky.domain.strategy.service.draw;

import pers.zymir.lucky.domain.strategy.model.req.DrawReq;
import pers.zymir.lucky.domain.strategy.model.res.DrawResult;

public interface IDrawService {

    DrawResult executeDraw(DrawReq drawReq);
}
