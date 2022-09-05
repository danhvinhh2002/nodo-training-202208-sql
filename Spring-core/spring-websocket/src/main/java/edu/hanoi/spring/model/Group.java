package edu.hanoi.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "V_Group",uniqueConstraints = {@UniqueConstraint(columnNames ="id")})
public class Group {
    @Column
    private String name;
    @Id
    private int id;

    public Group() {
    }

    public Group(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
