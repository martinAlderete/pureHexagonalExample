package com.gylgroup.fyc.domain.models;

public class City {

    private Long id;
    private String name;
    private Province provinceId;

    public City() {}

    public City(Long id, String name, Province provinceId) {
        this.id = id;
        this.name = name;
        this.provinceId = provinceId;
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

    public Province getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Province provinceId) {
        this.provinceId = provinceId;
    }
}

