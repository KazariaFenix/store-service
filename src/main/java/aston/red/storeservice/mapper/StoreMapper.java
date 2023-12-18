package aston.red.storeservice.mapper;

import aston.red.storeservice.dto.StoreDto;
import aston.red.storeservice.model.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StoreMapper {

    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    @Mapping(source = "phone", target = "phoneNumber")
    List<StoreDto> fromAllStoreToAllDto(List<Store> list);

    @Mapping(source = "phone", target = "phoneNumber")
    StoreDto fromStoreToDto(Store store);
}