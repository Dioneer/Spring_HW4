package Pegas.dto;

import java.time.LocalDate;

public record UserFilterDto(String firstName, String lastName, LocalDate birthday){
}
