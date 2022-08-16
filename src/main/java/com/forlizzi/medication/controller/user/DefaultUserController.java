package com.forlizzi.medication.controller.user;

import com.forlizzi.medication.entity.user.User;
import com.forlizzi.medication.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = {
        "http://localhost:3000"
    },
    allowedHeaders = "X-AUTH-TOKEN",
    allowCredentials = "false",
    maxAge = 15 * 60,
    methods = {
        RequestMethod.GET,
        RequestMethod.POST
    })
@Slf4j
public class DefaultUserController implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public int createUser(int userPK, String pseudoName, int age, String dateOfEval, String dateOfDischarge,
                          String medDxIcd, String txDxIcd) {
        return userService.createUser(userPK, pseudoName, age, dateOfEval, dateOfDischarge, medDxIcd, txDxIcd);
    }

    @Override
    public List<User> getUsers(int userPK) {
        return userService.getUsers(userPK);
    }

    @Override
    public void updateUser(String newPseudoName, int userPK) {
        log.debug("NewPseudoName={},UserPK={}", newPseudoName, userPK);
        userService.updateUser(newPseudoName, userPK);
    }

    @Override
    public void deleteUser(int userPK) {
        log.debug("DeletedUserPK:{}", userPK);
        userService.deleteUser(userPK);
    }

}