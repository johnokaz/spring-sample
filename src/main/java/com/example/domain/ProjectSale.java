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
@Table(name = "project_sales")
public class ProjectSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    // プロジェクトコード
    private String projectCd;

    // メンバーID
    private Integer memberId;
    
    // 売上年
    private String saleYear;
    
    // 売上月
    private String saleMonth;
    
    // 売上
    private Integer sale;
   
	// 要員情報
	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name="memberId", insertable=false, updatable=false)
	private Member member;
}
