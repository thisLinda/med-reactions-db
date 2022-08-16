package com.forlizzi.medication.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserMedList {
    private int userMedsListPK;
    private User pseudoName;
    private Medication brandName;

    @JsonIgnore
    public int getUserMedsListPK() {
        return userMedsListPK;
    }

}