package com.example.demo.web.controller;


import com.example.demo.apiPayload.ApiResponse;
import com.example.demo.converter.StoreConverter;
import com.example.demo.domain.Store;
import com.example.demo.service.StoreService.StoreCommandService;
import com.example.demo.web.dto.StoreRequestDTO;
import com.example.demo.web.dto.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions/{regionsid}/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping
    public ApiResponse<StoreResponseDTO.AddResultDTO> add( @PathVariable("regionsid") Long regionId,@RequestBody @Valid StoreRequestDTO.AddDTO request) {
        Store store = storeCommandService.addStore(regionId,request);
        return ApiResponse.onSuccess(StoreConverter.toAddResultDTO(store));
    }

}
