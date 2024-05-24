package com.example.demo.apiPayload.exception.handler;

import com.example.demo.apiPayload.code.BaseErrorCode;
import com.example.demo.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
