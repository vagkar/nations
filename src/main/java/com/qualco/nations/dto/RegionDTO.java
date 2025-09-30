package com.qualco.nations.dto;

public class RegionDTO {

    private Integer id;
    private String name;
    private String continentName;

    public RegionDTO(Integer id, String name, String continentName) {
        this.id = id;
        this.name = name;
        this.continentName = continentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }
}
