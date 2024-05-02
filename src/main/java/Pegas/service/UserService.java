package Pegas.service;

import Pegas.dto.UserCreateUpdateDto;
import Pegas.dto.UserReadDto;
import Pegas.entity.User;
import Pegas.mapper.UserCreateUpdateMapper;
import Pegas.mapper.UserReadMapper;
import Pegas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserCreateUpdateDto userCreateUpdateDto;
    private final UserReadDto userReadDto;
    private final UserCreateUpdateMapper userCreateUpdateMapper;
    private final UserReadMapper userReadMapper;
    private final UserRepository userRepository;

    public List<UserReadDto> findAll(){
        return userRepository.findAll().stream().map(userReadMapper::fromTo).toList();
    }

    public Optional<UserReadDto> findById(Long id){
        return userRepository.findById(id).map(userReadMapper::fromTo);
    }

    public UserReadDto create(UserCreateUpdateDto userCreateUpdateDto){
        return Optional.of(userCreateUpdateDto).map(i-> userCreateUpdateMapper.fromTo(i, new User()))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::fromTo)
                .orElseThrow();
    }

    public boolean delete(Long id){
        return userRepository.findById(id)
                .map(i-> {
                    userRepository.delete(i);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }

    public Optional<UserReadDto> update(Long id, UserCreateUpdateDto userCreateUpdateDto){
        return userRepository.findById(id).map(i-> userCreateUpdateMapper.fromTo(userCreateUpdateDto, i))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::fromTo);
    }
}
