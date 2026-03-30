package com.bst.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "employer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empname;
    private String companyname;
    private String phonenumber;

    @Column(unique = true)
    private String email;

    private String password;

    private String location;

    private String website;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<Internship> internships;
}