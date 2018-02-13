package com.ibm.lotte.excption;

import com.ibm.lotte.model.PredictVersion;

public class PredictionException extends RuntimeException {

    public PredictionException() {
    }

    public PredictionException(String msg) {
        super( msg );
    }
}
