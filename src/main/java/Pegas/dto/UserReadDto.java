package Pegas.dto;

import Pegas.entity.Role;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserReadDto {
    Long id;
    String username;
    String firstname;
    String lastname;
    LocalDate birthday;
    Role role;
    CompanyReadDto companyReadDto;
}
