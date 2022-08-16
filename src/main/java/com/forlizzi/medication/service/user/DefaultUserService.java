package com.forlizzi.medication.service.user;

import com.forlizzi.medication.dao.user.UserDao;
import com.forlizzi.medication.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public int createUser(int userPK, String pseudoName, int age, String dateOfEval, String dateOfDischarge,
                          String medDxIcd, String txDxIcd) {
        int user = userDao.createUser(userPK, pseudoName, age, dateOfEval, dateOfDischarge, medDxIcd, txDxIcd);
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers(int userPK) {
        List<User> users = userDao.getUsers(userPK);

        if(users.isEmpty()) {
            String msg = String.format("No users found with userPK=%s", userPK);
            throw new NoSuchElementException(msg);
        }
        return users;
    }

    @Override
    public void updateUser(String newPseudoName, int userPK) {
        userDao.updateUser(newPseudoName, userPK);
    }

    @Override
    public void deleteUser(int userPK) {
        userDao.deleteUser(userPK);
    }

}