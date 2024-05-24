package com.example.demo.service.StoreService;

import com.example.demo.domain.Store;
import com.example.demo.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    public Store addStore(Long regionId, StoreRequestDTO.AddDTO request);
}
