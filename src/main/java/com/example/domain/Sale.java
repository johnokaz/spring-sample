package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    
    private String sales_year;
    private String sales_month;
    
    private Integer software_sale;
    private Integer labor_cost;
    private Integer outsourcing_cost;
    private Integer division_cost;
    private Integer current_software_cost;
    private Integer gross_profit;
    private Integer sga;
    private Integer operating_income;
    private Integer non_operating_income;
    private Integer non_operating_expense;
    private Integer ordinary_income;
    
    private Timestamp createdOn;
    private Timestamp updatedOn;
    
}
