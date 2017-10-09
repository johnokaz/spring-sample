package com.example.web;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProjectSaleForm {
    @NotNull
    @Size(min = 1, max = 127)
    private String projectCd;

    private Integer memberId;
   
    private String saleYear;
    
    private String saleMonth;
    
    private Integer sale;
}
