package com.example.springmvcthymeleaf.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_customer")
    @SequenceGenerator(sequenceName = "seq_customer", name = "seq_customer", initialValue = 6)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 45)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String firstName;

    @Column(name = "last_name", length = 45)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String lastName;

    @Column(name = "email", length = 45)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String email;

    public Employee(Integer id, String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
    }

    public Employee() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                " Employee [ ID: %s, First Name: %s, Last Name: %s, Email: %s] ",
                id, firstName, lastName, email
        );
    }
}