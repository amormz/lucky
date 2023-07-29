package pers.zymir.lucky.exception;

import pers.zymir.basic.result.BusinessStatus;

public class BusinessException extends RuntimeException {
    public BusinessException(BusinessStatus businessStatus) {
        super(businessStatus.message());
    }
}
