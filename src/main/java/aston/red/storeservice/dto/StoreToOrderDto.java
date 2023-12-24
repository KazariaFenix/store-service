package aston.red.storeservice.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StoreToOrderDto {

    private Long id;

    private String name;

    private String phone;

    private String address;
}
