package Pegas.dto;

import Pegas.entity.Role;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Value
public class UserCreateUpdateDto{
    String username;
    String firstname;
    String lastname;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate birthday;
    Role role;
    Integer company_id;
}
