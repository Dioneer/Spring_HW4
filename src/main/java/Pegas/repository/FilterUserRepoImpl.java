package Pegas.repository;

import Pegas.dto.UserFilterDto;
import Pegas.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FilterUserRepoImpl implements FilterUserRepo{
    private final EntityManager entityManager;
    @Override
    public List<User> findAllByFilter(UserFilterDto filter) {
        var cb = entityManager.getCriteriaBuilder();
        var criteria = cb.createQuery(User.class);
        var user = criteria.from(User.class);
        criteria.select(user);

        List<Predicate> predicates = new ArrayList<>();
        if(filter.firstName() != null && !filter.firstName().isBlank()){
            predicates.add(cb.like(user.get("firstname"), filter.firstName()));
        }
        if(filter.lastName() != null && !filter.lastName().isBlank()){
            predicates.add(cb.like(user.get("lastname"), filter.lastName()));
        }
        if(filter.birthday() != null){
            predicates.add(cb.lessThan(user.get("birthday"), filter.birthday()));
        }
        criteria.where(predicates.toArray(jakarta.persistence.criteria.Predicate[]::new));
        return entityManager.createQuery(criteria).getResultList();
    }
}
