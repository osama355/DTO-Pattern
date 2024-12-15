package com.example.dtopattern.service.Imp;

import com.example.dtopattern.Mapping.UserMapping;
import com.example.dtopattern.dto.UserDto;
import com.example.dtopattern.entity.User;
import com.example.dtopattern.repository.UserRepository;
import com.example.dtopattern.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapping.toJpa(userDto);
        User saveUser = userRepository.save(user);
        return UserMapping.toDto(saveUser);
    }

    @Override
    public UserDto getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User user1 = user.get();
            return UserMapping.toDto(user1);
        }else{
            return null;
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserMapping::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUserById(int id,UserDto userDto) {
        Optional<User> searchUser = userRepository.findById(id);
        if(searchUser.isPresent()){
            User getSearchUser = searchUser.get();
            getSearchUser.setEmail(userDto.getEmail());
            getSearchUser.setFirstName(userDto.getFirstName());
            getSearchUser.setLastName(userDto.getLastName());
            getSearchUser.setPhoneNumber(userDto.getPhoneNumber());
            User user = userRepository.save(getSearchUser);
            return UserMapping.toDto(user);
        }else{
            return null;
        }
    }
}
