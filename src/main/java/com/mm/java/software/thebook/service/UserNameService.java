package com.mm.java.software.thebook.service;

import com.mm.java.software.thebook.model.UserName;
import com.mm.java.software.thebook.repository.UserNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class UserNameService {

    @Autowired
    UserNameRepository userNameRepository;


    public Optional<UserName> getUserByEmail(String email) {
        return userNameRepository.findByEmail(email);
    }

    public boolean addUserName(UserName userName) {
        String email = userName.getEmail();
        boolean isToAdd = true;
        for (UserName user : getAllUserName()) {
            if (user.getEmail().equals(email)) {
                isToAdd = false;
                break;
            }
        }
        if (isToAdd)
            userNameRepository.save(userName);
        return isToAdd;
    }

    public List<UserName> getAllUserName() {
        return (List<UserName>) userNameRepository.findAll();
    }

    public String getName(String email) {
        return Objects.requireNonNull(userNameRepository.findByEmail(email).orElse(null)).getName();
    }
}