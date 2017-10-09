package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "man_hours")
public class ManHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    // プロジェクトコード
    private String projectCd;

    // メンバーID
    private Integer memberId;
    
    // 工数年月
    @Temporal(TemporalType.DATE) 
    private Date manHourDate;
    
    // 工数
    private Double manHour;
   
	// 要員情報
	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name="memberId", insertable=false, updatable=false)
	private Member member;
}
