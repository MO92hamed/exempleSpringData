package com.mou.exemplespringdata.Service;

import com.mou.exemplespringdata.Model.dto.UserDto;
import com.mou.exemplespringdata.Model.entity.User;
import com.mou.exemplespringdata.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDto getOne(Integer id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
            return UserDto.toUserDto(user.get());
        else
            return null;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Boolean isExist(Integer id){
        return userRepository.existsById(id);
    }

    public void deleteOne(Integer id){
        userRepository.deleteById(id);
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }

    public UserDto createOne(UserDto userDto){
        return
                UserDto.toUserDto(userRepository.save(User.toUserEntity(userDto)));
    }

    public UserDto updateOne(UserDto userDto){
        return
                UserDto.toUserDto(userRepository.save(User.toUserEntity(userDto)));
    }
}
