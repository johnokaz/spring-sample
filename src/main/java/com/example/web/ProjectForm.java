package com.example.web;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProjectForm {
    @NotNull
    @Size(min = 1, max = 127)
    private String projectCd;

    @NotNull
    @Size(min = 1, max = 127)
    private String projectName;
    
    private Integer customerId;
    
    private Integer contractId;
    
}
