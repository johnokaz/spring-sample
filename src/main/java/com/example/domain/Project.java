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
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    // プロジェクトコード
    private String projectCd;

    // プロジェクト名
    private String projectName;
    
    // 顧客ID
    private Integer customerId;
    
    // 契約ID
    private Integer contractId;
        
    // 顧客情報
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name="customerId", insertable=false, updatable=false)
    private Customer customer;
}
