package com.enuca.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "company_tbl")
@Entity
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 3000, nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", orphanRemoval = true)
    private Set<EmployeeEntity> employeeEntityList = new HashSet<>();

    public CompanyEntity() {

    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<EmployeeEntity> getEmployeeEntityList() {
        return employeeEntityList;
    }

    public void setEmployeeEntityList(Set<EmployeeEntity> employeeEntityList) {
        this.employeeEntityList = employeeEntityList;
    }
}