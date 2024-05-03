package Pegas.service;

import Pegas.dto.UserCreateUpdateDto;
import Pegas.dto.UserFilterDto;
import Pegas.dto.UserReadDto;
import Pegas.entity.User;
import Pegas.mapper.UserCreateUpdateMapper;
import Pegas.mapper.UserReadMapper;
import Pegas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserCreateUpdateMapper userCreateUpdateMapper;
    private final UserReadMapper userReadMapper;
    private final UserRepository userRepository;

    public List<UserReadDto> findAll(){
        return userRepository.findAll().stream().map(userReadMapper::fromTo).toList();
    }

    public List<UserReadDto> findAll(UserFilterDto filter){
        return userRepository.findAllByFilter(filter).stream().map(userReadMapper::fromTo).toList();
    }

    public Page<UserReadDto> findAllBy(){
        var pageable = PageRequest.of(0,3, Sort.by("username"));
        List<UserReadDto> pages= userRepository.findAllBy(pageable).stream().map(userReadMapper::fromTo).toList();
        return new PageImpl<>(pages);
    }

    public Optional<UserReadDto> findById(Long id){
        return userRepository.findById(id).map(userReadMapper::fromTo);
    }

    @Transactional
    public UserReadDto create(UserCreateUpdateDto userCreateUpdateDto){
        return Optional.of(userCreateUpdateDto).map(userCreateUpdateMapper::fromTo)
                .map(userRepository::save)
                .map(userReadMapper::fromTo)
                .orElseThrow();
    }
    @Transactional
    public boolean delete(Long id){
        return userRepository.findById(id)
                .map(i-> {
                    userRepository.delete(i);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }
    @Transactional
    public Optional<UserReadDto> update(Long id, UserCreateUpdateDto userCreateUpdateDto){
        return userRepository.findById(id).map(i-> userCreateUpdateMapper.fromTo(userCreateUpdateDto, i))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::fromTo);
    }
}
