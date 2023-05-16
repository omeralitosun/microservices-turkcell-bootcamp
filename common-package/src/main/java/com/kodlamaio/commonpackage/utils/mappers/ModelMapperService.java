package com.kodlamaio.commonpackage.utils.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
