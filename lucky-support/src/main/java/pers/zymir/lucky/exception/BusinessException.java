package pers.zymir.lucky.exception;

import pers.zymir.common.exception.BaseException;
import pers.zymir.common.resp.Responsive;

public class BusinessException extends BaseException {
    public BusinessException(Responsive responsive) {
        super(responsive);
    }
}
