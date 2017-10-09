package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_ranks")
public class JobRank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    // 職能ランクコード
    private String jobRankCd;
    
    // 職能ランク名
    private String jobRankName;
    
    // 職能ランク年
    @Column(name="jobRankYear",columnDefinition="char(4)")
    private String jobRankYear;
    
    // 職能ランク原価
    private Integer cost;
}
