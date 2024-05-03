package Pegas.mapper;

import Pegas.dto.UserCreateUpdateDto;
import Pegas.entity.Company;
import Pegas.entity.User;
import Pegas.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserCreateUpdateMapper implements Mapper<UserCreateUpdateDto, User>{
    private final CompanyRepository companyRepository;

    public User fromTo(UserCreateUpdateDto from, User to){
        to.setUsername(from.getUsername());
        to.setFirstname(from.getFirstname());
        to.setLastname(from.getLastname());
        to.setBirthday(from.getBirthday());
        to.setRole(from.getRole());
        to.setCompany(getCompany(from.getCompany_id()));
        return to;
    }

    @Override
    public User fromTo(UserCreateUpdateDto userC) {
        return User.builder()
                .username(userC.getUsername())
                .firstname(userC.getFirstname())
                .lastname(userC.getLastname())
                .birthday(userC.getBirthday())
                .role(userC.getRole())
                .company(getCompany(userC.getCompany_id()))
                .build();
    }

    private Company getCompany(Integer companyId) {
        return Optional.ofNullable(companyId)
                .flatMap(companyRepository::findById)
                .orElse(null);
    }
}
