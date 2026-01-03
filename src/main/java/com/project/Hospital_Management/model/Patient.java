package com.project.Hospital_Management.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patients")
public class Patient extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    private String bloodGroup;
    private String emergencyContact;

    @Column(columnDefinition = "TEXT")
    private String medicalHistory;
}
