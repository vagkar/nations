package com.qualco.nations.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "continents")
public class Continent {

    @Id
    @Column(name = "continent_id")
    private Integer continentId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "continent")
    private List<Region> regions;

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
