package com.project.Hospital_Management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "doctors")
public class Doctor extends BaseEntity{

    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    private String specialization;
    private String qualification;
    private String department;

    private String availability;
}
