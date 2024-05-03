package Pegas.service;

import Pegas.dto.CompanyReadDto;
import Pegas.mapper.CompanyReadMapper;
import Pegas.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {
    private final CompanyReadMapper companyReadMapper;
    private final CompanyRepository companyRepository;

    public List<CompanyReadDto> findAll(){
        return companyRepository.findAll().stream().map(companyReadMapper::fromTo).toList();
    }
}
