package Pegas.mapper;

import Pegas.dto.CompanyReadDto;
import Pegas.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto>{
    @Override
    public CompanyReadDto fromTo(Company company) {
        return new CompanyReadDto(company.getId(), company.getCompanyName());
    }
}
