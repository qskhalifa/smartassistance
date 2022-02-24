package com.smartassistance.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    /**
     * The name of group
     */
    private String name;

    /**
     * The size of group
     */
    private String size;
    @ManyToMany
    private List<Module> moduleList;

    public Batch() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
