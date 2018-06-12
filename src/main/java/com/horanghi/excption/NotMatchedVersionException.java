package com.horanghi.excption;

public class NotMatchedVersionException extends PredictionException {

    public NotMatchedVersionException() {
        super();
    }

    public NotMatchedVersionException(String msg) {
        super(msg);
    }
}
