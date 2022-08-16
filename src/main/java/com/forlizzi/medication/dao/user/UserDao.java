package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.User;
import java.util.List;

public interface UserDao {

    int createUser(int userPK, String pseudoName, int age, String dateOfEval, String dateOfDischarge,
                   String medDxIcd, String txDxIcd);

    List<User> getUsers(int userPK);

    void updateUser(String newPseudoName, int userPK);

    void deleteUser(int userPK);

}