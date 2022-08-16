package com.forlizzi.medication.controller.user;

import com.forlizzi.medication.entity.user.UserMedList;
import com.forlizzi.medication.entity.user.UserMedListRequest;
import com.forlizzi.medication.service.user.UserMedListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class DefaultUserMedListController implements UserMedListController {

    @Autowired
    private UserMedListService userMedListService;

    @Override
    public UserMedList createUserMedList(UserMedListRequest userMedListRequest) {
        log.debug("UserMedList={}", userMedListRequest);
        return userMedListService.createUserMedList(userMedListRequest);
    }

}