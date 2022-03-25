package com.companyproject1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_seq",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_seq"
    )
    private Long id;
    private String courseName;
    private String duration;

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void setGroup(Group group) {
        if (groupList == null) {
            groupList = new ArrayList<>();
        }
        this.groupList.add(group);
    }
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "company_id")
    private Company company;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL,
            mappedBy = "courseList")
    private List<Group> groupList;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "course")
    private Teacher teacher;
}
