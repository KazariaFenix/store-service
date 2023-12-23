package aston.red.storeservice.service;

import aston.red.storeservice.model.Store;
import aston.red.storeservice.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository repository;

    public List<Store> getAll() {
        return repository.findAll();
    }

    public Store getAllGoodsByStore(long storeId) {
        repository.findById(storeId);
        return null;
    }
}
