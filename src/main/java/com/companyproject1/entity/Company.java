package com.companyproject1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
public class Company {

    @Id
    @SequenceGenerator(
            name = "company_seq",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_seq"
    )
    private Long id;
    private String companyName;
    private String locatedCountry;

    public Company(String companyName, String locatedCountry) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Course> courseList;
}
