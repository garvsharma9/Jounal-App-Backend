package com.journal.journalApp.Services;

import com.journal.journalApp.Entity.User;
import com.journal.journalApp.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    private static final Logger logger= LoggerFactory.getLogger(UserService.class);
    public void saveNewUser(User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
        }catch(Exception e)
        {


            log.error("you are trying to add duplicate user");
            log.warn("you are trying to add duplicate user");
            log.info("you are trying to add duplicate user");
            log.debug("you are trying to add duplicate user");
            log.trace("you are trying to add duplicate user");

        }

    }

    public void saveUser(User user) {
        try{
            userRepository.save(user);
        }catch(Exception e)
        {
            log.error("Error", e);
        }

    }

    public void saveAdmin(User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER", "ADMIN"));
            userRepository.save(user);
        }catch(Exception e)
        {
            log.error("Error", e);
        }

    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName)
    {
        return userRepository.findByUsername(userName);
    }

}
