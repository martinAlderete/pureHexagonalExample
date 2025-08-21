package com.gylgroup.fyc.domain.models;

import java.util.Set;

public class Role {
    private Long id;
    private String name;
    private Set<Permission> permissions;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
