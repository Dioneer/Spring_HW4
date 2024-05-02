package Pegas.dto;

import Pegas.entity.Company;
import Pegas.entity.Role;
import jakarta.persistence.*;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserCreateUpdateDto{
    String username;
    String firstname;
    String lastname;
    LocalDate birthday;
    Role role;
    Integer company_id;
}
