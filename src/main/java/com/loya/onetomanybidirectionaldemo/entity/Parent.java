package com.loya.onetomanybidirectionaldemo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Parent")
public class Parent implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name = "Name")
    public String name;


    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private Set<Child> children = new HashSet<>();


    public Parent() {
    }

    //getters and setters omitted for brevity


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }
}
