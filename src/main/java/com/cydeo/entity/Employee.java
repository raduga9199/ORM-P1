package com.cydeo.entity;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employees")
public class Employee extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE") //***
    private LocalDate hireDate;

    /**@ManyToOne(fetch = FetchType.LAZY)*/
    private Department department;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;

    private Region region; //***
}