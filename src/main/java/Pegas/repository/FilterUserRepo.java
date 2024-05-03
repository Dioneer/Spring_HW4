package Pegas.repository;

import Pegas.dto.UserFilterDto;
import Pegas.entity.User;

import java.util.List;

public interface FilterUserRepo {

    List<User> findAllByFilter(UserFilterDto filter);
}
