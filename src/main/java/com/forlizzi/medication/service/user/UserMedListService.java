package com.forlizzi.medication.service.user;

import com.forlizzi.medication.entity.user.UserMedList;
import com.forlizzi.medication.entity.user.UserMedListRequest;

public interface UserMedListService {

    UserMedList createUserMedList(UserMedListRequest userMedListRequest);

}