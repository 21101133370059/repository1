package com.springboot.dullah.footballImpl;

import com.springboot.dullah.entity.Football;
import com.springboot.dullah.repository.UserRepository;
import com.springboot.dullah.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public Football createFootball(Football football) {
        return userRepository.save(football);
    }

    @Override
    public Football getFootballById(Long footballId) {
        Optional<Football> optionalFootball=userRepository.findById(footballId);
        return optionalFootball.get();
    }

    @Override
    public List<Football> getAllFootball() {
        return userRepository.findAll();
    }

    @Override
    public Football updateFootball(Football football) {
        Football existingFootball=userRepository.findById(football.getId()).get();
        existingFootball.setName(football.getName());
        existingFootball.setLevel(football.getLevel());
        Football updataedFootball=userRepository.save(existingFootball);
        return updataedFootball;
    }

    @Override
    public void deleteFootball(Long footballId) {
        userRepository.deleteById(footballId);
    }
}
