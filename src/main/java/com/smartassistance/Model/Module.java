package com.smartassistance.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    /**
     * The name of the subject
     */
    private String name;

    /**
     * The code of the subject
     */
    private String code;

    /**
     * The list of teacher that teach the module.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Professor> professors;


    public Module() {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }
}
