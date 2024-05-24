package com.example.demo.service.StoreService;

import com.example.demo.apiPayload.code.status.ErrorStatus;
import com.example.demo.apiPayload.exception.handler.RegionHandler;
import com.example.demo.converter.StoreConverter;
import com.example.demo.domain.Region;
import com.example.demo.domain.Store;
import com.example.demo.repository.RegionRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store addStore(Long regionId, StoreRequestDTO.AddDTO request){
        Store newStore = StoreConverter.toStore(request);

        Region region = regionRepository.findById(regionId).orElseThrow(()-> new RegionHandler(ErrorStatus.REGION_NOT_EXIST));

        newStore.joinRegion(region);
        return storeRepository.save(newStore);

    }

    public boolean existsById(Long id){
        return storeRepository.existsById(id);
    }


}
