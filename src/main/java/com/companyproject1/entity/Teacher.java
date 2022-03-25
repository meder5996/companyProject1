package com.companyproject1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
@Data
@NoArgsConstructor
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_seq",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_seq"
    )
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    private String email;

    @Column(name = "last_name")
    private String lastName;

    public Teacher(String firstName, String email, String lastName) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
    }

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "course_id")
    private Course course;

}
