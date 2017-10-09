package com.example.web;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class MemberForm {
    @NotNull
    @Size(min = 1, max = 127)
    private String lastname;

    @NotNull
    @Size(min = 1, max = 127)
    private String firstname;
    
    private Integer jobRankId;
    
    private Integer memberKbn;
    
}
