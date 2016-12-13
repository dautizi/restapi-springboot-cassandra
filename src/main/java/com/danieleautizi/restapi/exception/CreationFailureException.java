package com.danieleautizi.restapi.exception;

public class CreationFailureException extends BaseException {

    public CreationFailureException() {
        super(ErrorCodes.CREATION_FAILURE_EXCEPTION);
    }

}
