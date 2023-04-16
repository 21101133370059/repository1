package com.springboot.dullah.controller;

import com.springboot.dullah.entity.Football;
import com.springboot.dullah.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping()
@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    //build craete football rest api
    @PostMapping
    public ResponseEntity<Football> createFootball(@RequestBody Football football){
        Football savedFootball=userService.createFootball(football);
        return new ResponseEntity<>(savedFootball, HttpStatus.CREATED);
    }

    //build get football rest api
    @GetMapping("{id}")
    public ResponseEntity<Football> getFootballById(@PathVariable("id") Long fottballId){
        Football football=userService.getFootballById(fottballId);
        return new ResponseEntity<>(football,HttpStatus.OK);
    }

    //build get all footballs rest api
    @GetMapping
    public ResponseEntity<List<Football>> getAllFootball() {
        List<Football> footballs=userService.getAllFootball();
        return new ResponseEntity<>(footballs,HttpStatus.OK);
    }
    //build update football by id rest api
    @PutMapping("{id}")
    public ResponseEntity<Football> updateFootball(@PathVariable("id") Long footballId, @RequestBody Football football){
        football.setId(footballId);
        Football updatedfootball=userService.updateFootball(football);
        return new ResponseEntity<>(updatedfootball, HttpStatus.OK);
    }
    //build delete football by id rest api
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteFootball(@PathVariable("id") Long footballId){
        userService.deleteFootball(footballId);
        return new ResponseEntity<>("Football Deleted Successfull", HttpStatus.OK);
    }

}
