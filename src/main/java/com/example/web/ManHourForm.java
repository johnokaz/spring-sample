package com.example.web;

import lombok.Data;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ManHourForm {
    @NotNull
    @Size(min = 1, max = 127)
    private String projectCd;

    private Integer memberId;
   
    private Date manHourDate;
    
    private Double manHour;
}
