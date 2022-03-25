package com.companyproject1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_seq",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seq"
    )
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    private String email;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "study_format")
    private String studyFormat;

    public Student(String firstName, String email, String lastName, String studyFormat) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.studyFormat = studyFormat;
    }


    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "group_id")
    private Group group;
}
