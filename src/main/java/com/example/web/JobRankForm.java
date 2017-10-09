package com.example.web;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class JobRankForm {
    @NotNull
    @Size(min = 1, max = 127)
    private String jobRankCd;

    @Size(min = 1, max = 127)
    private String jobRankName;
    
    @Size(min = 4, max = 4)
    private String jobRankYear;
    
    private Integer cost;

}
