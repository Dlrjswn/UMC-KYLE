package com.example.demo.converter;

import com.example.demo.domain.Store;
import com.example.demo.web.dto.StoreRequestDTO;
import com.example.demo.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.AddResultDTO toAddResultDTO(Store store) {
        return StoreResponseDTO.AddResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore( StoreRequestDTO.AddDTO request) {
        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .score(request.getScore())
                .build();
    }
}
