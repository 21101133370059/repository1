package com.springboot.dullah.service;

import com.springboot.dullah.entity.Football;

import java.util.List;

public interface UserService {
    Football createFootball(Football football);
    Football getFootballById(Long footballId);
    List<Football> getAllFootball();
    Football updateFootball(Football football);
    void deleteFootball(Long footballId);
}
