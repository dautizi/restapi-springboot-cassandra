package com.danieleautizi.restapi.exception;

public class NotFoundException extends BaseException {

    public NotFoundException() {
        super(ErrorCodes.NOT_FOUND_EXCEPTION);
    }

}
