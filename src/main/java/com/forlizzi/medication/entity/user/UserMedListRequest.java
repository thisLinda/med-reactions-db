package com.forlizzi.medication.entity.user;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class UserMedListRequest {
    @NotNull
    @Length(max = 30)
    @Pattern(regexp = "[\\w\\s]*")
    private String user;

    @NotNull
    @Length(max = 30)
    @Pattern(regexp = "[\\w\\s]*")
    private String medication;

}