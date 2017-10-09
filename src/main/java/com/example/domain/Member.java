package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    // 姓
    private String lastname;
    
    // 名
    private String firstname;
    
    // 職能ランクId
    private Integer jobRankId;
    
    // 要員区分
    private Integer memberKbn;
    
    // 職能ランク
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name="jobRankId", insertable=false, updatable=false)
    private JobRank JobRank;
}
