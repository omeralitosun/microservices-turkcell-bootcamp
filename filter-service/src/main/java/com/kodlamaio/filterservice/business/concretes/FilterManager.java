package com.kodlamaio.filterservice.business.concretes;

import com.kodlamaio.commonpackage.utils.mappers.ModelMapperService;
import com.kodlamaio.filterservice.business.abstracts.FilterService;
import com.kodlamaio.filterservice.business.dto.responses.GetAllFilterResponse;
import com.kodlamaio.filterservice.business.dto.responses.GetFilterResponse;
import com.kodlamaio.filterservice.entities.Filter;
import com.kodlamaio.filterservice.repository.FilterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FilterManager implements FilterService {
    private final FilterRepository repository;
    private final ModelMapperService mapper;

    @Override
    public List<GetAllFilterResponse> getAll() {
        var filters = repository.findAll();
        var response = filters
                .stream()
                .map(filter -> mapper.forResponse().map(filter,GetAllFilterResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetFilterResponse getById(UUID id) {
        var filter = repository.findById(id);
        var response = mapper.forResponse().map(filter,GetFilterResponse.class);

        return response;
    }

    @Override
    public void add(Filter filter) {
        filter.setId(UUID.randomUUID());
        repository.save(filter);
    }

    @Override
    public void delete(UUID id) {

        repository.deleteById(id);
    }

    @Override
    public void deleteAllByCarId(UUID carId) {
        repository.deleteAllByCarId(carId);
    }
    @Override
    public void deleteAllByBrandId(UUID brandId) {
        repository.deleteAllByBrandId(brandId);
    }

    @Override
    public void deleteAllByModelId(UUID modelId) {

    }

    @Override
    public Filter getByCarId(UUID carId) {
        return repository.findByCarId(carId);
    }
}
