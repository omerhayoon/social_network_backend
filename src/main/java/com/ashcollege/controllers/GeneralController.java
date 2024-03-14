package com.ashcollege.controllers;

import com.ashcollege.entities.User;
import com.ashcollege.responses.RegisterResponse;
import com.ashcollege.responses.UserResponse;
import com.ashcollege.utils.DbUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.ashcollege.utils.Errors.*;
import static java.lang.Integer.parseInt;

@RestController
public class GeneralController {
    List<User> userList = new ArrayList<>();
    UserResponse userResponse;

    @Autowired
     private DbUtils dbUtils;

    @RequestMapping("/")
    public String test() {
        return "Hello From Server";
    }


    @RequestMapping("/create_new_user")
    public RegisterResponse createNewUser(String username, String password, String repeat) {
        boolean success = false;
        Integer errorCode = null;
        Integer id = null;
        if (username != null) {
            if (password != null) {
                if (password.equals(repeat)) {
                    if (availableUsername(username)) {
                        User user = new User();
                        user.setUsername(username);
                        user.setPassword(password);
                        success = true;
                        if (dbUtils.availableUsername(username)){
                            dbUtils.registerUser(user);
                        }
                    } else {
                        errorCode = ERROR_USERNAME_NOT_FREE;
                    }
                } else {
                    errorCode = ERROR_PASSWORDS_DONT_MATCH;
                }
            } else {
                errorCode = ERROR_MISSING_PASSWORD;
            }
        } else {
            errorCode = ERROR_MISSING_USERNAME;
        }
        return new RegisterResponse(success, errorCode);

    }

    @RequestMapping("login")
    public RegisterResponse login(String username, String password, String token) {
        boolean connecting = false;
         Integer errorCode=null;
        if (username!=null){
            if (password!=null){
                for (User user:userList) {
                    if (username.equals(user.getUsername())&&username.equals(user.getPassword())){
                        connecting=true;
                        break;
                    }else {
                        errorCode=ERROR_USERNAME_NOT_CONTAIN_IN_THE_LIST;
                    }
                }
            }else {
                errorCode=ERROR_MISSING_PASSWORD;
            }

        }else {
            errorCode=ERROR_MISSING_USERNAME;

        }
        return  new RegisterResponse(connecting,errorCode);
    }

    public boolean availableUsername(String username) {
        boolean available = true;
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                available = false;
                break;
            }
        }
        return available;
    }

}


