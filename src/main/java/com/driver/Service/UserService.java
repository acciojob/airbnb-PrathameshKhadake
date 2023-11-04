package com.driver.Service;

import com.driver.Repository.UserRepository;
import com.driver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int addUser(User user){
        userRepository.addUser(user);
        return user.getaadharCardNo();
    }


}
