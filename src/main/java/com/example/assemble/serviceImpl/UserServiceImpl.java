package com.example.assemble.serviceImpl;

import com.example.assemble.dto.UserDto;
import com.example.assemble.entity.User;
import com.example.assemble.repository.UserRepository;
import com.example.assemble.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User saveUser(UserDto userDto) {
        User newUser = new User();
        newUser.setName(userDto.getName());
        newUser.setEmail(userDto.getEmail());
        newUser.setGender(userDto.getGender());
        newUser.setAddress(userDto.getAddress());
        newUser.setProfession(userDto.getProfession());

        return userRepository.save(newUser);
    }
}
