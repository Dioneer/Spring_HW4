package Pegas.mapper;

import Pegas.dto.UserCreateUpdateDto;
import Pegas.entity.User;

public class UserCreateUpdateMapper implements Mapper<UserCreateUpdateDto, User>{
    @Override
    public User fromTo(UserCreateUpdateDto userCreateUpdateDto) {
        return null;
    }
    public User fromTo(UserCreateUpdateDto userCreateUpdateDto, User user) {
        return User.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .username(user.getUsername())
                .role(user.getRole())
                .company(user.getCompany())
                .birthday(user.getBirthday())
                .build();
    }
}
