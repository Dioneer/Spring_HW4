package Pegas.mapper;

import Pegas.dto.CompanyReadDto;
import Pegas.dto.UserReadDto;
import Pegas.entity.User;

public class UserReadMapper implements Mapper<User, UserReadDto>{
    @Override
    public UserReadDto fromTo(User user) {
        return new UserReadDto(
                user.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getBirthday(),
                user.getRole(),
                new CompanyReadDto(user.getCompany().getId(), user.getCompany().getCompanyName())
        );
    }
}
