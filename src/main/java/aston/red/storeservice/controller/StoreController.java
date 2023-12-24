package aston.red.storeservice.controller;

import aston.red.storeservice.dto.StoreDto;
import aston.red.storeservice.dto.StoreToOrderDto;
import aston.red.storeservice.feign.GoodsFeignClient;
import aston.red.storeservice.mapper.StoreMapper;
import aston.red.storeservice.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping(path = "/store", produces = MediaType.APPLICATION_JSON_VALUE)
//@RequiredArgsConstructor
@AllArgsConstructor
public class StoreController {

    private final StoreService service;
    private final GoodsFeignClient goodsFeignClient;


    @GetMapping
    public List<StoreDto> getAll() {
        return StoreMapper.INSTANCE.fromAllStoreToAllDto(service.getAll());
    }

    @GetMapping(path = "/{storeId}")
    public StoreDto getByIdWithAllProducts(@PathVariable("storeId") long storeId) {
        StoreDto storeDto = StoreMapper.INSTANCE.fromStoreToDto(service.getById(storeId));
        storeDto.setProductDtoList(goodsFeignClient.getAllGoodsFromStore(storeId));
        return storeDto;
    }

    @GetMapping(path = "/{storeId}/{productId}")
    public StoreDto getByIdWithProduct(@PathVariable("storeId") long storeId,
                                       @PathVariable("productId") long productId) {
        StoreDto storeDto = StoreMapper.INSTANCE.fromStoreToDto(service.getById(storeId));
        storeDto.setProductDtoList(Collections.singletonList(goodsFeignClient.getGoodFromStore(storeId, productId)));
        return storeDto;
    }

    @GetMapping(path = "/transfer/{storeId}")
    public StoreToOrderDto getToOrderService(@PathVariable("storeId") long storeId) {
        return StoreMapper.INSTANCE.fromStoreToOrderService(service.getById(storeId));
    }
}
