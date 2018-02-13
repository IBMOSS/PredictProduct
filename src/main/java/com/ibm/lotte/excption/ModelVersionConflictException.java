package com.ibm.lotte.excption;


public class ModelVersionConflictException extends PredictionException {

    public ModelVersionConflictException() {
        super();
    }

    public ModelVersionConflictException(String msg) {
        super( msg );
    }
}
