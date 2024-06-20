package com.example.demo.service.TempService;

import com.example.demo.apiPayload.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.apiPayload.code.status.ErrorStatus;
@Service
@RequiredArgsConstructor
public class TempQuerySerivceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag){
        if(flag == 1){
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
        }
    }
}
