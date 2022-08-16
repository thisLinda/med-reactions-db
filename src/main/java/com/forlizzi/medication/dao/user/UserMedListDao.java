package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.Medication;
import com.forlizzi.medication.entity.user.User;
import com.forlizzi.medication.entity.user.UserMedList;
import java.util.Optional;

public interface UserMedListDao {

    UserMedList createUserMedList(User user, Medication medication);

    Optional<User> fetchUser(int userPK);

    Optional<Medication> fetchMedication(int medPK);

    Optional<User> fetchUserByPseudoName(String pseudoName);

    Optional<Medication> fetchMedicationByBrandName(String brandName);

}