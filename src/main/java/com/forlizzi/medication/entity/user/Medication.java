package com.forlizzi.medication.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Medication {
    private int medPK;
    private String brandName;
    private boolean hasReaction;

    @JsonIgnore
    public int getMedPK() {
        return medPK;
    }

}