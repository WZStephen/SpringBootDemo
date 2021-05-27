package com.example.SpringBootDemo.student;

import javax.persistence.*; //保持Hibernate
import java.time.LocalDate;
import java.time.Period;

@Entity //Hibernate
@Table //Table in the database

public class Student {
    @Id
    @SequenceGenerator( //用来定义一个生成主键的序列
            name = "students_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue( //定义主键生成策略
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
/**    Hibernate: create sequence student_sequence start 1 increment 50
    Hibernate:

    create table student (
            id int8 not null,
            age int4,
            dob date,
            email varchar(255),
    name varchar(255),
    primary key (id)
    )
 **/

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    @Transient //不会成为单独一列，短暂的
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() { //计算年龄

        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}


