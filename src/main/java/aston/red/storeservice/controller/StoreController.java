package aston.red.storeservice.controller;

import aston.red.storeservice.dto.StoreDto;
import aston.red.storeservice.mapper.StoreMapper;
import aston.red.storeservice.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/stores", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class StoreController {

    private final StoreService service;

    @GetMapping
    public List<StoreDto> getAll() {
        return StoreMapper.INSTANCE.fromAllStoreToAllDto(service.getAll());
    }

    @GetMapping(path = "/{id}")
    public StoreDto getById(@PathVariable("id") long storeId) {
        return StoreMapper.INSTANCE.fromStoreToDto(service.getById(storeId));
    }
}
