package Pegas.mapper;

import Pegas.dto.CompanyReadDto;
import Pegas.dto.UserReadDto;
import Pegas.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto>{
    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto fromTo(User user) {
        CompanyReadDto company = Optional.ofNullable(user.getCompany())
                .map(companyReadMapper::fromTo)
                .orElse(null);
        return new UserReadDto(
                user.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getBirthday(),
                user.getRole(),
                company
        );
    }
}
