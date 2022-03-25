package com.companyproject1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
@Data
@NoArgsConstructor
public class Group {
    @Id
    @SequenceGenerator(
            name = "group_seq",
            sequenceName = "group_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "group_seq"
    )
    private Long id;

    @Column(name = "group_name")
    private String groupName;
    @Column(name = "date_of_start")
    private String dateOfStart;
    @Column(name = "date_of_finish")
    private String dateOfFinish;

    public Group(String groupName, String dateOfStart, String dateOfFinish) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "course_groups", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courseList;

    public void setCourse(Course course) {
        if (courseList == null) {
            courseList = new ArrayList<>();
        }
        this.courseList.add(course);
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Student> studentList;
}
